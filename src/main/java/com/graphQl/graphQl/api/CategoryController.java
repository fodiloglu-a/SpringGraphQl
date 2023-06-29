package com.graphQl.graphQl.api;


import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphQl.graphQl.facet.dto.CategoryDTO;
import com.graphQl.graphQl.services.CategoryServices;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller

public class CategoryController implements GraphQLMutationResolver, GraphQLQueryResolver {

    private  final CategoryServices categoryServices;
    @QueryMapping
    public List<CategoryDTO> getAllCategory() {
        return categoryServices.getAll();
    }



    @MutationMapping
    public CategoryDTO createCategory(@Argument CategoryDTO categoryDTO) {
        return categoryServices.create(categoryDTO);
    }

    @QueryMapping
    public CategoryDTO getCategoryById(@Argument int categoryId) {
        return categoryServices.getById(categoryId);
    }

    @MutationMapping
    public String deleteCategory(@Argument int categoryId) {
        return categoryServices.delete(categoryId);
    }
    @MutationMapping
    public CategoryDTO updateCategory(@Argument CategoryDTO categoryDTO, int updateCategoryId){
        return categoryServices.update(categoryDTO,updateCategoryId);}



    }
