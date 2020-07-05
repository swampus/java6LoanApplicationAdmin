package java6.credit.loan.application.service;

import org.springframework.stereotype.Component;

@Component
public class CalculationService {

    public double calculateAmount(long summa,
                                  long interests) {
        return summa +
                Math.round(summa * interests / 100.0);
    }

}
