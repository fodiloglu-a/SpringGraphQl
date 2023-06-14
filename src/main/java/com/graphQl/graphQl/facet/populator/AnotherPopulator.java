package com.graphQl.graphQl.facet.populator;

import com.graphQl.graphQl.facet.dto.AnotherDTO;
import com.graphQl.graphQl.model.AnotherModel;
import org.springframework.stereotype.Component;

@Component
public class AnotherPopulator implements Populator<AnotherDTO,AnotherModel>{


    @Override
    public AnotherDTO populate(AnotherDTO target, AnotherModel source) {
        target.setName(source.getName());
        target.setSurname(source.getSurname());
        target.setEMail(source.getEMail());
        target.setAddress(source.getAddress());
        target.setResume(source.getResume());
        target.setNationality(source.getNationality());
        target.setCategoryModels(source.getCategoryModels());
        target.setBookModels(source.getBookModels());
        return target;



    }

    @Override
    public AnotherModel rePopulate(AnotherModel source, AnotherDTO target) {
        source.setName(target.getName());
        source.setSurname(target.getSurname());
        source.setAddress(target.getAddress());
        source.setEMail(target.getEMail());
        source.setResume(target.getResume());
        source.setNationality(target.getNationality());
        source.setCategoryModels(target.getCategoryModels());
        source.setBookModels(target.getBookModels());
        return source;


    }
}
