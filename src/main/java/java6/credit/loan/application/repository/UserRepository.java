package java6.credit.loan.application.repository;

import java6.credit.loan.application.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
        extends CrudRepository<User, Long> {
    //Search user
    //UpdateApplicationStatus

    User findByPhone(String phone);

}
