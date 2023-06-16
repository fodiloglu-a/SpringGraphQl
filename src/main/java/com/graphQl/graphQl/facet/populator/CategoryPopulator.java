package com.graphQl.graphQl.facet.populator;

import com.graphQl.graphQl.facet.converter.AnotherConverter;
import com.graphQl.graphQl.facet.converter.BookConverter;
import com.graphQl.graphQl.facet.dto.CategoryDTO;
import com.graphQl.graphQl.model.CategoryModel;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


public class CategoryPopulator implements Populator<CategoryDTO, CategoryModel> {
    @Resource
    private   BookConverter bookConverter;
    @Resource
    private  AnotherConverter anotherConverter;
    @Override
    public CategoryDTO populate(CategoryDTO target, CategoryModel source) {
        target.setName(source.getName());
        target.setSummary(source.getSummary());
        target.setBookModels(bookConverter.convertAll(source.getBookModels()));
        target.setAnotherModels(anotherConverter.convertAll(source.getAnotherModels()));
        return target;

    }

    @Override
    public CategoryModel rePopulate(CategoryModel source, CategoryDTO target) {
        source.setName(target.getName());
        source.setSummary(target.getSummary());
        source.setAnotherModels(anotherConverter.reConvertAll(target.getAnotherModels()));
        source.setBookModels(bookConverter.reConvertAll(target.getBookModels()));
        return source;
    }
}
