package com.graphQl.graphQl.facet.populator;

import com.graphQl.graphQl.facet.converter.AnotherConverter;
import com.graphQl.graphQl.facet.converter.CategoryConverter;

import com.graphQl.graphQl.facet.dto.BookDTO;

import com.graphQl.graphQl.model.BookModel;
import jakarta.annotation.Resource;

public class BookPopulator implements Populator<BookDTO, BookModel>{
    @Resource
    private   AnotherConverter anotherConverter;
    @Resource
    private   CategoryConverter categoryConverter;
    @Override
    public BookDTO populate(BookDTO target, BookModel source) {
        target.setName(source.getName());
        target.setSummary(source.getSummary());
        target.setPageCount(source.getPageCount());
        target.setPublicationDate(source.getPublicationDate());
        target.setCategoryModel(categoryConverter.convert(target.getCategoryModel(), source.getCategoryModel()));
        target.setAnotherModel(anotherConverter.convert(target.getAnotherModel(),source.getAnotherModel()));
        return target;

    }

    @Override
    public BookModel rePopulate(BookModel source, BookDTO target) {
        source.setName(target.getName());
        source.setSummary(target.getSummary());
        source.setPageCount(target.getPageCount());
        source.setPublicationDate(target.getPublicationDate());
        source.setAnotherModel(anotherConverter.reConvert(source.getAnotherModel(),target.getAnotherModel()));
        source.setCategoryModel(categoryConverter.reConvert(source.getCategoryModel(),target.getCategoryModel()));
        return source;

    }
}
