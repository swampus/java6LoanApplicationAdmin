package java6.credit.loan.application.model;

import javax.persistence.*;
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

    @Column
    private BigDecimal amount;

    @Column
    private String type;

    @ManyToOne
    private User user;

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
}
