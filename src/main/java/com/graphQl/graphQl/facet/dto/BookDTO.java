package com.graphQl.graphQl.facet.dto;

import com.graphQl.graphQl.model.AnotherModel;
import com.graphQl.graphQl.model.CategoryModel;
import lombok.Data;


import java.util.Date;
@Data
public class BookDTO {
    private String name;

    private String summary;

    private int pageCount;

    private Date publicationDate;


    private AnotherDTO anotherModel;

    private CategoryDTO categoryModel;
}
