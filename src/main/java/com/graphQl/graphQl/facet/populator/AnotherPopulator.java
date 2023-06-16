package com.graphQl.graphQl.facet.populator;

import com.graphQl.graphQl.facet.converter.BookConverter;
import com.graphQl.graphQl.facet.converter.CategoryConverter;
import com.graphQl.graphQl.facet.dto.AnotherDTO;
import com.graphQl.graphQl.model.AnotherModel;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


public class AnotherPopulator implements Populator<AnotherDTO,AnotherModel>{


    @Resource
    private  CategoryConverter categoryConverter;
    @Resource
    private  BookConverter bookConverter;
    @Override
    public AnotherDTO populate(AnotherDTO target, AnotherModel source) {
        target.setName(source.getName());
        target.setSurname(source.getSurname());
        target.setEMail(source.getEMail());
        target.setAddress(source.getAddress());
        target.setResume(source.getResume());
        target.setNationality(source.getNationality());
        target.setCategoryModels(categoryConverter.convertAll(source.getCategoryModels()));
        target.setBookModels(bookConverter.convertAll(source.getBookModels()));
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
        source.setCategoryModels(categoryConverter.reConvertAll(target.getCategoryModels()));
        source.setBookModels(bookConverter.reConvertAll(target.getBookModels()));
        return source;


    }
}
