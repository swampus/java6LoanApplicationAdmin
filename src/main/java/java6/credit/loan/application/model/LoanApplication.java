package java6.credit.loan.application.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.jmx.snmp.UserAcl;
import java6.credit.loan.application.annotation.ValidField;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public final class LoanApplication {

    @Id
    @GeneratedValue
    private long loanApplicationPk;

    @Column
    private LoanApplicationStatus loanApplicationStatus;

    @Column(name = "[from]")
    private Date from;

    @Column(name = "[to]")
    private Date to;

    @Min(value = 50, message = "Minumum valuee is 50")
    @Max(value = 300, message = "Maximum length is 300")
    @Column
    private BigDecimal amount;

    @Column(name = "type", length = 50)
    @NotBlank(message = "AAAAAAAAAAAAAAAAAAAAAA")
    private String type;

    @ManyToOne
    private User user;

    @ManyToOne
    private Interests interest;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getLoanApplicationPk() {
        return loanApplicationPk;
    }

    public void setLoanApplicationPk(long loanApplicationPk) {
        this.loanApplicationPk = loanApplicationPk;
    }

    public LoanApplicationStatus getLoanApplicationStatus() {
        return loanApplicationStatus;
    }

    public void setLoanApplicationStatus(LoanApplicationStatus loanApplicationStatus) {
        this.loanApplicationStatus = loanApplicationStatus;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Interests getInterest() {
        return interest;
    }

    public void setInterest(Interests interest) {
        this.interest = interest;
    }

    @Override
    public String toString() {
        return "LoanApplication{" +
                "loanApplicationPk=" + loanApplicationPk +
                ", loanApplicationStatus=" + loanApplicationStatus +
                ", from=" + from +
                ", to=" + to +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                '}';
    }
}
