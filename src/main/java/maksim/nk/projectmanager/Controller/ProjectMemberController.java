package maksim.nk.projectmanager.Controller;

import maksim.nk.projectmanager.Model.Project;
import maksim.nk.projectmanager.Model.ProjectMember;
import maksim.nk.projectmanager.Service.ProjectMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project-members")
public class ProjectMemberController {

    private final ProjectMemberService projectMemberService;

    @Autowired
    public ProjectMemberController(ProjectMemberService projectMemberService) {
        this.projectMemberService = projectMemberService;
    }

    @PostMapping
    public ResponseEntity<Void> addMemberToProject(@RequestBody ProjectMember projectMember) {
        projectMemberService.addMemberToProject(projectMember);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProjectMember>> getAllMembers() {
        List<ProjectMember> members = projectMemberService.getAll();
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @GetMapping("/by-project/{projectId}")
    public ResponseEntity<List<ProjectMember>> getMembersByProject(@PathVariable Long projectId) {
        Project project = new Project();
        project.setProjectId(projectId);

        List<ProjectMember> members = projectMemberService.getMemberByProject(project);
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<ProjectMember> getMemberById(@PathVariable Long memberId) {
        ProjectMember member = projectMemberService.getMemberById(memberId);
        return member != null
                ? new ResponseEntity<>(member, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
