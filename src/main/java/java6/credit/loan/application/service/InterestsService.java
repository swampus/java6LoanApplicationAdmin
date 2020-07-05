package java6.credit.loan.application.service;

import java6.credit.loan.application.model.Interests;
import java6.credit.loan.application.repository.InterestsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InterestsService {

    @Autowired
    private InterestsRepository interestsRepository;

    public List<Interests> getAllInterests(){
        return interestsRepository.findAll();
    }

    public Interests getInterestById(Long id){
        return interestsRepository.getOne(id);
    }

    public List<Interests> getAllByType(String type){
        return interestsRepository.findByType(type);
    }

}
