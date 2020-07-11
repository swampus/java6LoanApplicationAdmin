package java6.credit.loan.application.controller;

import java6.credit.loan.application.Application;
import java6.credit.loan.application.dto.UserDTO;
import java6.credit.loan.application.dto.UserMapper;
import java6.credit.loan.application.model.User;
import java6.credit.loan.application.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController("/api/rest/User.svc")
public class UserController {
    private static Logger LOG
            = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        LOG.info("getUserById: " + id);
        return userMapper
                .toDto(userService.getUserById(id));
    }

    @GetMapping("/users")
    public List<UserDTO> getAllUsers() {
        LOG.info("getAllUsers");
        return userService.getAllUsers()
                .stream()
                .map(t -> userMapper.toDto(t))
                .collect(Collectors.toList());
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody UserDTO userDto) {
        LOG.info("saveUser: " + userDto);
        User user = userMapper.fromDto(userDto);
        userService.saveUser(user);
    }

    @GetMapping("/user/phone_number/{phoneNumber}")
    public UserDTO findUserByPhone(@PathVariable String phoneNumber) {
        LOG.info("findUserByPhone: " + phoneNumber);
        return userMapper
                .toDto(userService.findUserByPhone(phoneNumber));

    }

}
