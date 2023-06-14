package com.graphQl.graphQl.facet.dto;

import com.graphQl.graphQl.model.BookModel;
import com.graphQl.graphQl.model.CategoryModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class AnotherDTO {
    private String name;

    private String surname;

    private String address;

    private String eMail;

    private String resume;

    private String nationality;


    private List<CategoryModel> categoryModels;


    private List<BookModel> bookModels = new ArrayList<>();
}
