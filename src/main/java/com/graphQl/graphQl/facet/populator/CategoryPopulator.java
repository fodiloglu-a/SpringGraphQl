package com.graphQl.graphQl.facet.populator;

import com.graphQl.graphQl.facet.converter.AnotherConverter;
import com.graphQl.graphQl.facet.converter.BookConverter;
import com.graphQl.graphQl.facet.dto.CategoryDTO;
import com.graphQl.graphQl.model.CategoryModel;
import jakarta.annotation.Resource;



public class CategoryPopulator implements Populator<CategoryDTO, CategoryModel> {
    @Resource
    private   BookConverter bookConverter;
    @Resource
    private  AnotherConverter anotherConverter;
    @Override
    public CategoryDTO populate(CategoryDTO target, CategoryModel source) {
        target.setName(source.getName());
        target.setSummary(source.getSummary());
        if (!source.getBookModels().isEmpty()){
            try {
                target.setBookModels(bookConverter.convertAll(source.getBookModels()));
            }catch (Exception e){
                e.getMessage();
            }
        }

        if (!source.getAnotherModels().isEmpty()){
            try {
                target.setAnotherModels(anotherConverter.convertAll(source.getAnotherModels()));
            }catch (Exception e){
                e.getMessage();
            }
        }
        return target;

    }

    @Override
    public CategoryModel rePopulate(CategoryModel source, CategoryDTO target) {
        source.setName(target.getName());
        source.setSummary(target.getSummary());
        if(!target.getBookModels().isEmpty()){
            try {
                source.setBookModels(bookConverter.reConvertAll(target.getBookModels()));
            }catch (Exception e){
                e.getMessage();
            }
        }
        if(!target.getAnotherModels().isEmpty()){
            try {
                source.setAnotherModels(anotherConverter.reConvertAll(target.getAnotherModels()));
            }catch (Exception e){
                e.getMessage();
            }
        }


        return source;
    }
}
