package java6.credit.loan.application.dto;

import java6.credit.loan.application.model.LoanApplication;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

public class UserDTO {

    private Long userPk;
    private String name;
    private String surname;
    private String personalCode;
    private String phoneNumber;
    private List<Long> loanApplicationsIds;

    public Long getUserPk() {
        return userPk;
    }

    public void setUserPk(Long userPk) {
        this.userPk = userPk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(String personalCode) {
        this.personalCode = personalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Long> getLoanApplicationsIds() {
        return loanApplicationsIds;
    }

    public void setLoanApplicationsIds(List<Long> loanApplicationsIds) {
        this.loanApplicationsIds = loanApplicationsIds;
    }
}
