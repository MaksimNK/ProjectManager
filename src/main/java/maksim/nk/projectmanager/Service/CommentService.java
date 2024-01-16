package maksim.nk.projectmanager.Service;

import maksim.nk.projectmanager.Model.СommentEntity;
import maksim.nk.projectmanager.Repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void saveComment(СommentEntity comment) {
        commentRepository.save(comment);
    }

    public List<СommentEntity> getAllComments() {
        return commentRepository.findAll();
    }

    public СommentEntity getCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null);
    }

    public void updateComment(СommentEntity comment) {
        commentRepository.save(comment);
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
