package com.graphQl.graphQl.facet.converter;


import com.graphQl.graphQl.facet.dto.CategoryDTO;
import com.graphQl.graphQl.facet.populator.CategoryPopulator;

import com.graphQl.graphQl.model.CategoryModel;
import jakarta.annotation.Resource;


import java.util.ArrayList;
import java.util.List;


public class CategoryConverter implements Convert<CategoryDTO, CategoryModel> {
    @Resource
    private CategoryPopulator populator;

    @Override
    public CategoryDTO convert(CategoryDTO categoryDTO, CategoryModel categoryModel) {
        return populator.populate(categoryDTO, categoryModel);
    }

    @Override
    public CategoryModel reConvert(CategoryModel categoryModel, CategoryDTO categoryDTO) {
        return populator.rePopulate(categoryModel, categoryDTO);
    }

    @Override
    public List<CategoryDTO> convertAll(List<CategoryModel> categoryModels) {
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        List<CategoryModel> categoryModelList = categoryModels;
        for (CategoryModel categoryModel : categoryModelList) {
            CategoryDTO categoryDTO = null;
            categoryDTOS.add(populator.populate(categoryDTO, categoryModel));
        }

        return categoryDTOS;
    }

    @Override
    public List<CategoryModel> reConvertAll(List<CategoryDTO> categoryDTOS) {
        List<CategoryModel> categoryModelList = new ArrayList<>();

        for (CategoryDTO dto : categoryDTOS) {
            CategoryModel model = null;
            categoryModelList.add(populator.rePopulate(model, dto));
        }

        return categoryModelList;
    }
}
