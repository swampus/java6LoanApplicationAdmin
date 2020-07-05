package java6.credit.loan.application.controller;

import java6.credit.loan.application.model.LoanApplication;
import java6.credit.loan.application.model.LoanApplicationStatus;
import java6.credit.loan.application.service.LoanApplicationService;
import java6.credit.loan.application.service.validator.LoanApplicationValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/rest/LoanApplication.svc")
public class LoanApplicationController {

    @Autowired
    private LoanApplicationService loanApplicationService;

    @Autowired
    private LoanApplicationValidatorService loanApplicationValidatorService;

    @PostMapping("/loanApplication")
    public void saveLoanApplication(
            @RequestBody @Valid LoanApplication loanApplication) {

        long userId = loanApplication.getUser().getUserPk();
        loanApplicationValidatorService.isMaxApplicationCountReach(userId);

        loanApplicationService.saveLoanApplication(loanApplication);

    }


    @GetMapping("/loanApplication/{id}")
    public LoanApplication getLoanApplicationById(@PathVariable Long id) {
        return loanApplicationService.getLoanApplicationById(id);
    }

    @GetMapping("/loanApplications")
    public List<LoanApplication> getLoanApplications() {
        return loanApplicationService.getAllLoanApplications();
    }


    @PostMapping("/loanApplication/{id}/{status}")
    public void changeLoanApplicationStatus(@PathVariable Long id,
                                            @PathVariable LoanApplicationStatus status) {
        loanApplicationService
                .changeLoanApplicationStatus(id, status);
    }


}
