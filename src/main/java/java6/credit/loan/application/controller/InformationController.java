package java6.credit.loan.application.controller;

import java6.credit.loan.application.Application;
import java6.credit.loan.application.annotation.ValidField;
import java6.credit.loan.application.model.misc.ServerInformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Date;

@RestController
@RequestMapping("/api/rest/ServerInformation.svc")
public class InformationController {

    private static Logger LOG
            = LoggerFactory.getLogger(Application.class);
    private static Date serverStartDate;


    @Value("${project.author}")
    private String author;

    @Value("${my.value}")
    private String myValue;

    @PostConstruct
    private void init() {
        LOG.info("OBJECT CREATED!");
        serverStartDate = new Date();
    }

    @GetMapping("/ServerInformation")
    public ServerInformation getServerInfo() {
        ServerInformation serverInformation
                = new ServerInformation(author,
                new Date(), serverStartDate, myValue);
        return serverInformation;
    }

}
