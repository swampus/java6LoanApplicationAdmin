package java6.credit.loan.application.controller;

import java6.credit.loan.application.model.LoanApplication;
import java6.credit.loan.application.model.LoanApplicationStatus;
import java6.credit.loan.application.service.LoanApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api/rest/LoanApplication.svc")
public class LoanApplicationController {

    @Autowired
    private LoanApplicationService loanApplicationService;

    @PostMapping("/loanApplication")
    public void saveLoanApplication(
            @RequestBody LoanApplication loanApplication) {

        if(loanApplication.getAmount().longValue() < 50
                || loanApplication.getAmount().longValue() > 300){
            throw new RuntimeException("Wrong long value;");
        }

        loanApplicationService.saveLoanApplication(loanApplication);
    }

    @PostMapping("/updateApplication")
    public void updateApplication2(
            @RequestBody LoanApplication loanApplication) {

        if(loanApplication.getAmount().longValue() < 50
                || loanApplication.getAmount().longValue() > 300){
            throw new RuntimeException("Wrong long value;");
        }

        loanApplicationService.saveLoanApplication(loanApplication);
    }

    @PostMapping("/saveQuniquuwieApplication")
    public void erteetrert(
            @RequestBody LoanApplication loanApplication) {

        if(loanApplication.getAmount().longValue() < 50
                || loanApplication.getAmount().longValue() > 300){
            throw new RuntimeException("Wrong long value;");
        }

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
