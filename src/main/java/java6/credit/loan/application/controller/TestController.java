package java6.credit.loan.application.controller;

import com.sun.org.apache.bcel.internal.generic.GETFIELD;
import java6.credit.loan.application.model.LoanApplication;
import java6.credit.loan.application.model.LoanApplicationStatus;
import java6.credit.loan.application.model.User;
import java6.credit.loan.application.service.CalculationService;
import java6.credit.loan.application.service.LoanApplicationService;
import java6.credit.loan.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    private CalculationService calculationService;

    @Value("${my.value}")
    private String value;


    @GetMapping("/env")
    public String showEnvironment(){
        return value;
    }

    @GetMapping("/summa/{amount}/{interests}")
    public double getTotalSum(@PathVariable long amount,
                              @PathVariable long interests){
        return calculationService.calculateAmount(amount, interests);
    }


    @GetMapping("/generateData")
    public String generateData(){
        LoanApplication loanApplication = new LoanApplication();
        loanApplication.setLoanApplicationStatus(LoanApplicationStatus.APPROVED);
        loanApplication.setAmount(new BigDecimal(100));
        loanApplication.setFrom(new Date());
        loanApplication.setTo(new Date());
        loanApplication.setType("T1");

        LoanApplication loanApplication2 = new LoanApplication();
        loanApplication2.setLoanApplicationStatus(LoanApplicationStatus.PENDING);
        loanApplication2.setAmount(new BigDecimal(88));
        loanApplication2.setFrom(new Date());
        loanApplication2.setTo(new Date());
        loanApplication2.setType("T1");

        LoanApplication loanApplication3 = new LoanApplication();
        loanApplication3.setLoanApplicationStatus(LoanApplicationStatus.APPROVED);
        loanApplication3.setAmount(new BigDecimal(69));
        loanApplication3.setFrom(new Date());
        loanApplication3.setTo(new Date());
        loanApplication3.setType("T1");

        LoanApplication loanApplication4 = new LoanApplication();
        loanApplication4.setLoanApplicationStatus(LoanApplicationStatus.REJECTED);
        loanApplication4.setAmount(new BigDecimal(100));
        loanApplication4.setFrom(new Date());
        loanApplication4.setTo(new Date());
        loanApplication4.setType("T2");

        LoanApplication loanApplication5 = new LoanApplication();
        loanApplication5.setLoanApplicationStatus(LoanApplicationStatus.APPROVED);
        loanApplication5.setAmount(new BigDecimal(200));
        loanApplication5.setFrom(new Date());
        loanApplication5.setTo(new Date());
        loanApplication5.setType("T2");

        User user = new User();
        user.setPersonalCode("32423423");
        user.setPhoneNumber("11211212");
        user.setSurname("Ivanovs");
        user.setName("Dmitrijs");

        Set<LoanApplication> loanApplications = new HashSet<>();
        loanApplications.add(loanApplication);
        loanApplications.add(loanApplication2);

        Set<LoanApplication> loanApplications2 = new HashSet<>();
        loanApplications2.add(loanApplication3);
        loanApplications2.add(loanApplication4);
        loanApplications2.add(loanApplication5);


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
        loanApplication5.setUser(userPersisted2);

        loanApplicationService.saveLoanApplication(loanApplication);
        loanApplicationService.saveLoanApplication(loanApplication2);
        loanApplicationService.saveLoanApplication(loanApplication3);
        loanApplicationService.saveLoanApplication(loanApplication4);
        loanApplicationService.saveLoanApplication(loanApplication5);

        return "all saved";
    }

}
