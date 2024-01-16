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

    public void save (Project project) {
        projectRepository.save(project);
    }

    public List<Project> getAllProject() {
        return projectRepository.findAll();
    }

    public Project getById(Long projectId) {
        return projectRepository.findById(projectId).orElse(null);
    }

    public void updateProject(Project project) {
        projectRepository.save(project);
    }

    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }

}
