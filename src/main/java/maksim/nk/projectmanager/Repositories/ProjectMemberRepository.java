package maksim.nk.projectmanager.Repositories;

import maksim.nk.projectmanager.Model.Project;
import maksim.nk.projectmanager.Model.ProjectMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, Long> {

    List<ProjectMember> findByProject (Project project);
}
