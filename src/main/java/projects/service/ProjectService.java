package projects.service;
 import java.sql.SQLException;
 import projects.entity.Project;
 import projects.util.ProjectDao;

public class ProjectService {
  private ProjectDao projectDao = new ProjectDao();

  public Project addProject(Project project) throws SQLException {
    return projectDao.insertProject(project);
  }
}
