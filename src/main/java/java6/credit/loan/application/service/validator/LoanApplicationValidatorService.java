package java6.credit.loan.application.service.validator;

import java6.credit.loan.application.model.LoanApplication;
import java6.credit.loan.application.model.User;
import java6.credit.loan.application.repository.LoanApplicationRepository;
import java6.credit.loan.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LoanApplicationValidatorService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoanApplicationRepository loanApplicationRepository;

    public void isMaxApplicationCountReach(long userId) {
      /*  userRepository.findById(userId).ifPresent(t -> {
            if (t.getLoanApplications().size() >= 3) {
                throw new RuntimeException("Max App count reach");
            }
        });*/
/*        User user = userRepository.findById(userId).get();
        List<LoanApplication> loanApplicationList
                = loanApplicationRepository.findByUser(user);

        if (loanApplicationList.size() >= 3) {
            throw new RuntimeException("Max App count reach");
        }*/

        List<LoanApplication> list = new ArrayList<>();
        Iterable<LoanApplication> loanApplicationList =
                loanApplicationRepository.findAll();
        loanApplicationList.forEach(list::add);

        long count = list.stream().filter(app ->
                app.getUser().getUserPk().equals(userId))
                .count();
        if (count >= 3) {
            throw new RuntimeException("Max App count reach");
        }

    }
}
