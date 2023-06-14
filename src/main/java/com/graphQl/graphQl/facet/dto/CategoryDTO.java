package com.graphQl.graphQl.facet.dto;

import com.graphQl.graphQl.model.AnotherModel;
import com.graphQl.graphQl.model.BookModel;
import lombok.Data;

import java.util.List;
@Data
public class CategoryDTO {
    private String name;
    private String summary;
    private List<BookDTO> bookModels;
    private List<AnotherDTO> anotherModels;

}
