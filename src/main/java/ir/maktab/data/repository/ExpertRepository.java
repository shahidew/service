package ir.maktab.data.repository;

import ir.maktab.data.entity.ImageFile;
import ir.maktab.data.entity.Expert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExpertRepository extends JpaRepository<Expert, Long>, JpaSpecificationExecutor<Expert> {

    Optional<Expert> findExpertByImageFilesContains(ImageFile imageFile);

   // @Query(value = "select * from Expert u where u.emailAddress = :email AND u.password = :password", nativeQuery = true)
    Optional<Expert> findExpertByEmailAddressAndPassword(String email, String password);

    Optional<Expert> findExpertByEmailAddress(String email);
}
