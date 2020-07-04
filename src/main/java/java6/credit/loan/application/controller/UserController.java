package java6.credit.loan.application.controller;

import java6.credit.loan.application.Application;
import java6.credit.loan.application.model.User;
import java6.credit.loan.application.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController("/api/rest/User.svc")
public class UserController {
    private static Logger LOG
            = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Long id){
        LOG.info("getUserById: " + id);
        return userService.getUserById(id);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        LOG.info("getAllUsers");
        return userService.getAllUsers();
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody User user){
        LOG.info("saveUser: " + user);
        userService.saveUser(user);
    }

    @GetMapping("/user/phone_number/{phoneNumber}")
    public User findUserByPhone(@PathVariable String phoneNumber){
        LOG.info("findUserByPhone: " + phoneNumber);
        return userService.findUserByPhone(phoneNumber);
    }

}
