package java6.credit.loan.application.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Interests {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String type;

    @Column
    private Long rate;

    @OneToMany(mappedBy = "interest",
            fetch = FetchType.EAGER)
    private Set<LoanApplication> loanApplicationList = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getRate() {
        return rate;
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }

    public Set<LoanApplication> getLoanApplicationList() {
        return loanApplicationList;
    }

    public void setLoanApplicationList(Set<LoanApplication> loanApplicationList) {
        this.loanApplicationList = loanApplicationList;
    }
}
