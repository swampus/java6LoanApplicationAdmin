package java6.credit.loan.application.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long userPk;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String personalCode;

    @Column
    private String phoneNumber;

    @Column
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<LoanApplication> loanApplications;

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

    public Set<LoanApplication> getLoanApplications() {
        return loanApplications;
    }

    public void setLoanApplications(Set<LoanApplication> loanApplications) {
        this.loanApplications = loanApplications;
    }

    @Override
    public String toString() {
        return "User{" +
                "userPk=" + userPk +
                ", user='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", personalCode='" + personalCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", loanApplications=" + loanApplications +
                '}';
    }
}
