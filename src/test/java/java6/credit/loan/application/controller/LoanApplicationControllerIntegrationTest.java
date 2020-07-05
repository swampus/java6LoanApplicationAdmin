package java6.credit.loan.application.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static java.lang.Thread.sleep;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class LoanApplicationControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getLoanApplicationById() throws Exception {

        mockMvc.perform(get("/generateData"))
                .andExpect(status().isOk());

        sleep(2000);

        mockMvc.perform(get("/api/rest/LoanApplication.svc/loanApplication/3")
                .content("asd"))
                .andExpect(status().isOk());
    }
}