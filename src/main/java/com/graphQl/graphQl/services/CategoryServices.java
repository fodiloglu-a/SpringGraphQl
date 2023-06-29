package com.graphQl.graphQl.services;

import com.graphQl.graphQl.facet.dto.CategoryDTO;

import java.util.List;

public interface CategoryServices {
    List<CategoryDTO> getAll();

    CategoryDTO create(CategoryDTO categoryDTO);

    CategoryDTO getById(int id);

    String delete(int id);

    CategoryDTO update(CategoryDTO categoryDTO, int updateId);
}
