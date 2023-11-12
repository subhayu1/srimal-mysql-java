package projects;

import exception.DbException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import projects.service.ProjectService;
import projects.entity.Project;

public class ProjectsApp {
  // @formatter:off
  private List<String> operations = List.of(
      "1) Add a project"
  );
  // @formatter:on
  private Scanner scanner = new Scanner(System.in);
  private ProjectService projectService = new ProjectService();

  public static void main(String[] args) {
    new ProjectsApp().processUserSelections();
  }

  private void processUserSelections() {
    boolean done = false;
    while (!done) {
      /*
       Inside the while loop, add a try/catch block. The catch block should catch Exception.
       Inside the catch block print the Exception message. Call the toString() method on the
        Exception object provided to the catch block. This is done by simply concatenating the
         Exception object onto a String literal.
       When you do this Java implicitly calls the toString() method behind the scenes.
       */
      try {
        int selection = getUserSelection();

        switch (selection) {
          case -1:
            done = exitMenu();
            break;
          case 1:
            createProject();
            break;
          default:
            System.out.println("Invalid selection. Please try again.");
        }
      }
      catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
  }


  private int getUserSelection() {
    printOperations();
    Integer input = getIntInput("Enter a  menu selection ");
    return Objects.isNull(input) ? -1 : input;
  }

  private Integer getIntInput(String prompt) {
    String input = getStringInput(prompt);
    if (Objects.isNull(input) || input.isEmpty()) {
      return null;
    }
    try {
      return Integer.parseInt(input);
    } catch (NumberFormatException e) {
      throw new DbException("Invalid input. Please enter a number.");
    }
  }
  // Method to get a string input from the user
  private String getStringInput(String prompt) {
    System.out.print(prompt + ": ");
    String input = scanner.nextLine();

    // Return trimmed input or null if blank
    return input.isBlank() ? null : input.trim();
  }


  private void printOperations() {
    System.out.println("\nThese are the available selections. Press Enter to quit:");
    operations.forEach(line -> System.out.println(" "+ line));
  }

  // Method to get BigDecimal input from the user
  private BigDecimal getDecimalInput(String prompt) {
    String input = getStringInput(prompt);

    // Return null if input is null to handle optional inputs
    if (Objects.isNull(input)) {
      return null;
    }

    // Parse the input into a BigDecimal with two decimal places
    try {
      return new BigDecimal(input).setScale(2);
    } catch (NumberFormatException e) {
      throw new DbException(input + " is not a valid decimal number.");
    }
  }
  // Method to handle the exit from the menu
  private boolean exitMenu() {
    System.out.println("Exiting the menu.");
    return true;
  }
  private void createProject() throws SQLException {
    String projectName = getStringInput("Enter the project name");
    BigDecimal estimatedHours = getDecimalInput("Enter the estimated hours");
    BigDecimal actualHours = getDecimalInput("Enter the actual hours");
    Integer difficulty = getIntInput("Enter the project difficulty (1-5)");
    String notes = getStringInput("Enter the project notes");
    Project project = new Project();
    project.setProjectName(projectName);
    project.setEstimatedHours(estimatedHours);
    project.setActualHours(actualHours);
    project.setDifficulty(difficulty);
    project.setNotes(notes);
    Project dbProject = projectService.addProject(project);
    System.out.println("You have successfully created project: " + dbProject);
  }

}
