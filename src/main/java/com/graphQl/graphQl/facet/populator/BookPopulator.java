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
        if (source.getCategoryModel() != null){try {
            target.setCategoryModel(categoryConverter.convert(target.getCategoryModel(), source.getCategoryModel()));
        }catch (Exception e){
            e.getMessage();
        }
        }
        if (source.getAnotherModel() !=null){
            try {
                target.setAnotherModel(anotherConverter.convert(target.getAnotherModel(),source.getAnotherModel()));
            }catch (Exception e){
                e.getMessage();
            }

        }

        return target;

    }

    @Override
    public BookModel rePopulate(BookModel source, BookDTO target) {
        source.setName(target.getName());
        source.setSummary(target.getSummary());
        source.setPageCount(target.getPageCount());
        source.setPublicationDate(target.getPublicationDate());
        if (target.getCategoryModel() != null){try {
            source.setCategoryModel(categoryConverter.reConvert(source.getCategoryModel(),target.getCategoryModel()));
        }catch (Exception e){
            e.getMessage();
        }
        }
        if (target.getAnotherModel() !=null){
            try {
                source.setAnotherModel(anotherConverter.reConvert(source.getAnotherModel(),target.getAnotherModel()));
            }catch (Exception e){
                e.getMessage();
            }

        }



        return source;

    }
}
