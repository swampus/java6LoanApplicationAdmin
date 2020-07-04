package java6.credit.loan.application.exception;

public class LoanApplicationNotFoundException
        extends RuntimeException {

    public LoanApplicationNotFoundException(String message) {
        super(message);
    }

}
