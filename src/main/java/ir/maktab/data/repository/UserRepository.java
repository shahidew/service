package ir.maktab.data.repository;

import ir.maktab.data.entity.User;
import ir.maktab.data.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    Optional<User> findUserByFullName(String fullName);

    Optional<User> findUserByEmailAddress(String email);

    List<User> findUserByUserRole(UserRole role);

    Optional<User> findUserByPassword(String password);

}
