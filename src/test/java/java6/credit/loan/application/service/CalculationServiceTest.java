package java6.credit.loan.application.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculationServiceTest {

    public CalculationService calculationService = new CalculationService();

    @Test
    public void calculateAmount() {

        assertEquals(110, calculationService.calculateAmount(100, 10));
        assertEquals(80, calculationService.calculateAmount(40, 100));
    }
}