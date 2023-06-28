package com.graphQl.graphQl.services;

import com.graphQl.graphQl.facet.dto.AnotherDTO;

import java.util.List;

public interface AnotherServices {
    List<AnotherDTO> getAll();

    AnotherDTO create(AnotherDTO anotherDTO);

    AnotherDTO getById(int id);

    String delete(int id);

    AnotherDTO update(AnotherDTO anotherDTO, int updateId);
}
