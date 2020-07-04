package java6.credit.loan.application.repository;

import java6.credit.loan.application.model.Interests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public interface InterestsRepository
        extends JpaRepository<Interests, Long> {

    List<Interests> findByType(String type);

}
