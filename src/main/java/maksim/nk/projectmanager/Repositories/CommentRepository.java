package maksim.nk.projectmanager.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import maksim.nk.projectmanager.Model.Сomment;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Сomment, Long> {

}
