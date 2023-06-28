package com.graphQl.graphQl.facet.dto;


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


    private List<CategoryDTO> categoryModels=new ArrayList<>();


    private List<BookDTO> bookModels = new ArrayList<>();
}
