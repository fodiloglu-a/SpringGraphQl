package com.graphQl.graphQl.services;

import com.graphQl.graphQl.facet.dto.BookDTO;

import java.util.List;

public interface BookServices {
    List<BookDTO> getAll();

    BookDTO create(BookDTO bookDTO);

    BookDTO getById(int updateBookId);

    String delete(int deleteBookId);

    BookDTO update(BookDTO bookDTO, int updateBookId);
}
