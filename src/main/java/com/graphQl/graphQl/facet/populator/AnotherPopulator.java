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
        if (source.getCategoryModels()!=null){
            try {
                target.setCategoryModels(categoryConverter.convertAll(source.getCategoryModels()));

            }catch (Exception e){
                e.getMessage();
            }
        }
        if (source.getBookModels()!=null){
            try {
                target.setBookModels(bookConverter.convertAll(source.getBookModels()));

            }catch (Exception e){
                e.getMessage();
            }
        }



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
        if (target.getCategoryModels()!=null){
            try {
                source.setCategoryModels(categoryConverter.reConvertAll(target.getCategoryModels()));

            }catch (Exception e){
                e.getMessage();
            }
        }
        if (target.getBookModels()!=null){
            try {
                source.setBookModels(bookConverter.reConvertAll(target.getBookModels()));
            }catch (Exception e){
                e.getMessage();
            }
        }


        return source;


    }
}
