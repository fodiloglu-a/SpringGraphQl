package com.graphQl.graphQl.facet.populator;

import com.graphQl.graphQl.facet.dto.AnotherDTO;
import com.graphQl.graphQl.facet.dto.BookDTO;
import com.graphQl.graphQl.facet.dto.CategoryDTO;
import com.graphQl.graphQl.model.BookModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookPopulator implements Populator<BookDTO, BookModel>{
    private final AnotherPopulator anotherPopulator;
    private final CategoryPopulator categoryPopulator;
    @Override
    public BookDTO populate(BookDTO target, BookModel source) {
        target.setName(source.getName());
        target.setSummary(source.getSummary());
        target.setPageCount(source.getPageCount());
        AnotherDTO anotherDTO=new AnotherDTO();
        anotherDTO= anotherPopulator.populate(anotherDTO,source.getAnotherModel());
        target.setAnotherModel(anotherDTO);
        CategoryDTO categoryDTO=null;
        categoryDTO=categoryPopulator.populate(categoryDTO,source.getCategoryModel());
        target.setCategoryModel(categoryDTO);

        return target;

    }

    @Override
    public BookModel rePopulate(BookModel source, BookDTO target) {

        return source;

    }
}
