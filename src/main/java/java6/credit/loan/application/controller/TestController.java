package java6.credit.loan.application.controller;

import java6.credit.loan.application.model.LoanApplication;
import java6.credit.loan.application.model.LoanApplicationStatus;
import java6.credit.loan.application.model.User;
import java6.credit.loan.application.service.LoanApplicationService;
import java6.credit.loan.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@RestController
public class TestController {

    @Autowired
    private LoanApplicationService loanApplicationService;

    @Autowired
    private UserService userService;

    @GetMapping("/generateData")
    public String generateData(){
        LoanApplication loanApplication = new LoanApplication();
        loanApplication.setLoanApplicationStatus(LoanApplicationStatus.APPROVED);
        loanApplication.setAmount(new BigDecimal(100));
        loanApplication.setFrom(new Date());
        loanApplication.setTo(new Date());

        LoanApplication loanApplication2 = new LoanApplication();
        loanApplication2.setLoanApplicationStatus(LoanApplicationStatus.PENDING);
        loanApplication2.setAmount(new BigDecimal(2222));
        loanApplication2.setFrom(new Date());
        loanApplication2.setTo(new Date());

        LoanApplication loanApplication3 = new LoanApplication();
        loanApplication3.setLoanApplicationStatus(LoanApplicationStatus.APPROVED);
        loanApplication3.setAmount(new BigDecimal(4545));
        loanApplication3.setFrom(new Date());
        loanApplication3.setTo(new Date());

        LoanApplication loanApplication4 = new LoanApplication();
        loanApplication4.setLoanApplicationStatus(LoanApplicationStatus.REJECTED);
        loanApplication4.setAmount(new BigDecimal(100000000));
        loanApplication4.setFrom(new Date());
        loanApplication4.setTo(new Date());

        User user = new User();
        user.setPersonalCode("32423423");
        user.setPhoneNumber("11211212");
        user.setSurname("Ivanovs");
        user.setName("Dmitrijs");

        Set<LoanApplication> loanApplications = new HashSet<>();
        loanApplications.add(loanApplication);
        loanApplications.add(loanApplication2);

        Set<LoanApplication> loanApplications2 = new HashSet<>();
        loanApplications.add(loanApplication3);
        loanApplications.add(loanApplication4);


        user.setLoanApplications(loanApplications);

        User user2 = new User();
        user2.setPersonalCode("436345");
        user2.setPhoneNumber("222222");
        user2.setSurname("Sidorovs");
        user2.setName("Aleks");
        user2.setLoanApplications(loanApplications2);



        User userPersisted = userService.saveUser(user);
        User userPersisted2 = userService.saveUser(user2);

        loanApplication.setUser(userPersisted);
        loanApplication2.setUser(userPersisted);

        loanApplication3.setUser(userPersisted2);
        loanApplication4.setUser(userPersisted2);

        loanApplicationService.saveLoanApplication(loanApplication);
        loanApplicationService.saveLoanApplication(loanApplication2);
        loanApplicationService.saveLoanApplication(loanApplication3);
        loanApplicationService.saveLoanApplication(loanApplication4);

        return "all saved";
    }

}
