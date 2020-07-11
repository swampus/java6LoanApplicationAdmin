package java6.credit.loan.application.dto;

import java6.credit.loan.application.model.Interests;
import java6.credit.loan.application.model.LoanApplicationStatus;
import java6.credit.loan.application.model.User;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

public class LoanApplicationDTO {

    private long loanApplicationPk;

    private LoanApplicationStatus loanApplicationStatus;

    private Date from;

    private Date to;

    private BigDecimal amount;

    private String type;

    private long userId;

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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
