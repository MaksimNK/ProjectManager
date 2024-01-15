package maksim.nk.projectmanager.Service;

import jakarta.transaction.Transactional;
import maksim.nk.projectmanager.Model.Project;
import maksim.nk.projectmanager.Model.Task;
import maksim.nk.projectmanager.Repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public void createProject (Project project) {
        projectRepository.save(project);
    }

    public List<Project> getAllTask() {
        return projectRepository.findAll();
    }

    public Project findById(Long projectId) {
        return projectRepository.findById(projectId).orElse(null);
    }

    public void updateProject(Project project) {
        projectRepository.save(project);
    }

    public void deleteProject(Project project) {
        projectRepository.delete(project);
    }

}
