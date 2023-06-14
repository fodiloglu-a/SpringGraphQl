package com.graphQl.graphQl.facet.populator;

import com.graphQl.graphQl.facet.dto.CategoryDTO;
import com.graphQl.graphQl.model.CategoryModel;

public class CategoryPopulator implements Populator<CategoryDTO, CategoryModel> {
    @Override
    public CategoryDTO populate(CategoryDTO categoryDTO, CategoryModel categoryModel) {
        return categoryDTO;

    }

    @Override
    public CategoryModel rePopulate(CategoryModel categoryModel, CategoryDTO categoryDTO) {
            return categoryModel;
    }
}
