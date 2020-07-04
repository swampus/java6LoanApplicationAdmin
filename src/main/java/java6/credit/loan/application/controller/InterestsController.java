package java6.credit.loan.application.controller;

import java6.credit.loan.application.model.Interests;
import java6.credit.loan.application.service.InterestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rest/Interests.svc")
public class InterestsController {

    @Autowired
    private InterestsService interestsService;

    @GetMapping("/interests/{id}")
    public Interests findById(@PathVariable Long id){
        return interestsService.getInterestById(id);
    }

}
