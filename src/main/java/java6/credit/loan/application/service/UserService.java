package java6.credit.loan.application.service;

import java6.credit.loan.application.exception.LoanApplicationNotFoundException;
import java6.credit.loan.application.model.LoanApplication;
import java6.credit.loan.application.model.User;
import java6.credit.loan.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new LoanApplicationNotFoundException(
                        "User with id: " + id + " Not found!"));
    }

    public List<User> getAllUsers() {
        Iterable<User> iterable
                = userRepository.findAll();
        List<User> result
                = new ArrayList<>();
        iterable.forEach(result::add);
        return result;
    }

}
