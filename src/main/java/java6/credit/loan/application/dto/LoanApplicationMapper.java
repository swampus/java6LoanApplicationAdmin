package java6.credit.loan.application.dto;

import java6.credit.loan.application.model.LoanApplication;
import java6.credit.loan.application.model.User;
import org.springframework.stereotype.Component;

@Component
public class LoanApplicationMapper {

    public LoanApplication fromDto(LoanApplicationDTO loanApplicationDTO){
        LoanApplication loanApplication = new LoanApplication();
        loanApplication.setLoanApplicationPk(loanApplicationDTO.getLoanApplicationPk());
        loanApplication.setType(loanApplicationDTO.getType());
        loanApplication.setTo(loanApplicationDTO.getTo());
        loanApplication.setFrom(loanApplicationDTO.getFrom());
        loanApplication.setAmount(loanApplicationDTO.getAmount());
        loanApplication.setLoanApplicationStatus(loanApplicationDTO.getLoanApplicationStatus());
        User user = new User();
        user.setUserPk(loanApplicationDTO.getUserId());
        loanApplication.setUser(user);
        return loanApplication;
    }

    public LoanApplicationDTO toDto(LoanApplication loanApplication){
        LoanApplicationDTO loanApplicationDTO = new LoanApplicationDTO();
        loanApplicationDTO.setLoanApplicationPk(loanApplication.getLoanApplicationPk());
        loanApplicationDTO.setType(loanApplication.getType());
        loanApplicationDTO.setTo(loanApplication.getTo());
        loanApplicationDTO.setFrom(loanApplication.getFrom());
        loanApplicationDTO.setAmount(loanApplication.getAmount());
        loanApplicationDTO.setLoanApplicationStatus(loanApplication
                .getLoanApplicationStatus());
        loanApplicationDTO.setUserId(loanApplication.getUser().getUserPk());
        return loanApplicationDTO;
    }

}
