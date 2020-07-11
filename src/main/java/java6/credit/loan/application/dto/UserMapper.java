package java6.credit.loan.application.dto;

import java6.credit.loan.application.model.LoanApplication;
import java6.credit.loan.application.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public User fromDto(UserDTO userDto) {
        User user = new User();
        user.setUserPk(userDto.getUserPk());
        user.setSurname(userDto.getSurname());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setPersonalCode(userDto.getPersonalCode());
        user.setName(userDto.getName());
        List<Long> applicationsIds = userDto.getLoanApplicationsIds();
        user.setLoanApplications(applicationsIds.stream().map(t -> {
            LoanApplication app = new LoanApplication();
            app.setLoanApplicationPk(t);
            return app;
        }).collect(Collectors.toSet()));
        return user;
    }

    public UserDTO toDto(User user) {
        UserDTO userDto = new UserDTO();
        userDto.setUserPk(user.getUserPk());
        userDto.setSurname(user.getSurname());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setPersonalCode(user.getPersonalCode());
        userDto.setName(user.getName());

        Set<LoanApplication> apps = user.getLoanApplications();
        userDto.setLoanApplicationsIds(
                apps.stream()
                        .map(LoanApplication::getLoanApplicationPk)
                        .collect(Collectors.toList()));
        return userDto;

    }

}
