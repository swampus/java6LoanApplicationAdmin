package java6.credit.loan.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.money.Monetary;
import javax.money.MonetaryAmount;
import java.math.BigDecimal;

import static javafx.scene.input.KeyCode.DOLLAR;

@SpringBootApplication
public class Application {
    private static Logger LOG
            = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        LOG.info("Application started");
        SpringApplication.run(Application.class, args);
    }
}
