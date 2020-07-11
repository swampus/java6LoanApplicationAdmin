package java6.credit.loan.application.controller;

import java6.credit.loan.application.dto.LoanApplicationDTO;
import java6.credit.loan.application.dto.LoanApplicationMapper;
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

    @Autowired
    private LoanApplicationMapper loanApplicationMapper;

    @PostMapping("/loanApplication")
    public void saveLoanApplication(
            @RequestBody @Valid LoanApplicationDTO loanApplicationDTO) {

        long userId = loanApplicationDTO.getUserId();
        loanApplicationValidatorService.isMaxApplicationCountReach(userId);

        LoanApplication loanApplication
                = loanApplicationMapper.fromDto(loanApplicationDTO);

        loanApplicationService.saveLoanApplication(loanApplication);

    }


    @GetMapping("/loanApplication/{id}")
    public LoanApplicationDTO getLoanApplicationById(@PathVariable Long id) {
        LoanApplication loanApplication
                = loanApplicationService.getLoanApplicationById(id);
        LoanApplicationDTO loanApplicationDTO
                = loanApplicationMapper.toDto(loanApplication);
        return loanApplicationDTO;

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
