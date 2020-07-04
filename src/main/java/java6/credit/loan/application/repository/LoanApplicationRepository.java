package java6.credit.loan.application.repository;

import java6.credit.loan.application.model.LoanApplication;
import java6.credit.loan.application.model.LoanApplicationStatus;
import java6.credit.loan.application.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanApplicationRepository
        extends CrudRepository<LoanApplication, Long> {

}
