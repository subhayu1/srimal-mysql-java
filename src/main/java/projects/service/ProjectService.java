package projects.service;
 import exception.DbException;
 import java.sql.SQLException;
 import java.util.List;
 import java.util.NoSuchElementException;
 import projects.entity.Project;
 import projects.util.ProjectDao;

public class ProjectService {
  private ProjectDao projectDao = new ProjectDao();

  public Project addProject(Project project) throws SQLException {
    return projectDao.insertProject(project);
  }

  public Project fetchProjectById(Integer projectId) {
    return projectDao.fetchProjectById(projectId).orElseThrow(() -> new NoSuchElementException(
        "No project found with id: " + projectId
    ));

  }

  public List<Project> fetchAllProjects() {
    return projectDao.fetchAllProjects();
  }

  public void deleteProject(Integer projectId) {
    if (!projectDao.deleteProject(projectId)) {
      throw new DbException("No project found with id: " + projectId);
    }
  }

  public void modifyProjectDetails(Project project) {
    if (!projectDao.modifyProjectDetails(project)) {
      throw new DbException("No project found with id: " + project.getProjectId());
    }
  }
}
