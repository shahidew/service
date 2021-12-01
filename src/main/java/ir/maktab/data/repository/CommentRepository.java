package ir.maktab.data.repository;
import ir.maktab.data.entity.Comment;
import ir.maktab.data.entity.Expert;
import ir.maktab.data.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    Optional<Comment> findCommentByCustomer(Customer customer);

    Optional<Comment> findCommentByExpert(Expert expert);
}
