package java6.credit.loan.application.controller;

import java6.credit.loan.application.model.LoanApplication;
import java6.credit.loan.application.model.LoanApplicationStatus;
import java6.credit.loan.application.service.LoanApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoanApplicationController {

    @Autowired
    private LoanApplicationService loanApplicationService;

    public void saveLoanApplication(LoanApplication loanApplication) {
        loanApplicationService.saveLoanApplication(loanApplication);
    }

    public LoanApplication getLoanApplicationById(Long id) {
        return loanApplicationService.getLoanApplicationById(id);
    }

    public List<LoanApplication> getLoanApplications() {
        return loanApplicationService.getAllLoanApplications();
    }

    public void changeLoanApplicationStatus(Long id,
                                            LoanApplicationStatus loanApplicationStatus) {
        loanApplicationService
                .changeLoanApplicationStatus(id, loanApplicationStatus);
    }


}
