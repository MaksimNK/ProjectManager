package maksim.nk.projectmanager.Service;

import jakarta.transaction.Transactional;
import maksim.nk.projectmanager.Model.Project;
import maksim.nk.projectmanager.Model.ProjectMember;
import maksim.nk.projectmanager.Repositories.ProjectMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProjectMemberService {

    private final ProjectMemberRepository memberRepository;

    @Autowired
    public ProjectMemberService(ProjectMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public void addMemberToProject(ProjectMember projectMember) {
        memberRepository.save(projectMember);
    }

    public List<ProjectMember> getAll() {
        return memberRepository.findAll();
    }

    public List<ProjectMember> getMemberByProject(Project project) {
        return memberRepository.findByProject(project);
    }

    public ProjectMember getMemberById(Long memberId) {
        return memberRepository.findById(memberId).orElse(null);
    }

}
