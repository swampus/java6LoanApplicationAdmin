package java6.credit.loan.application.service;

import java6.credit.loan.application.exception.LoanApplicationNotFoundException;
import java6.credit.loan.application.model.LoanApplication;
import java6.credit.loan.application.model.LoanApplicationStatus;
import java6.credit.loan.application.model.User;
import java6.credit.loan.application.repository.LoanApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class LoanApplicationService {

    @Autowired
    private LoanApplicationRepository loanApplicationRepository;

    public LoanApplication getLoanApplicationById(Long id) {
        return loanApplicationRepository
                .findById(id).orElseThrow(
                        () -> new LoanApplicationNotFoundException(
                                "Loan application with id: " + id + " Not found!"));
    }

    public List<LoanApplication> getAllLoanApplications() {
        Iterable<LoanApplication> iterable
                = loanApplicationRepository.findAll();
        List<LoanApplication> result
                = new ArrayList<>();
        iterable.forEach(result::add);

        return result;
    }

    public void changeLoanApplicationStatus(Long id,
                                            LoanApplicationStatus status) {

        loanApplicationRepository.findById(id).ifPresent(
                loanApplication -> {
                    loanApplication.setLoanApplicationStatus(status);
                    loanApplicationRepository.save(loanApplication);
                }
        );
    }

    public void saveLoanApplication(LoanApplication loanApplication){
        loanApplicationRepository.save(loanApplication);
    }
}
