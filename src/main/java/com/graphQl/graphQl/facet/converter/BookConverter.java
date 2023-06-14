package com.graphQl.graphQl.facet.converter;

import com.graphQl.graphQl.facet.dto.BookDTO;
import com.graphQl.graphQl.model.BookModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookConverter  implements Convert<BookDTO, BookModel> {



    @Override
    public void convert(BookDTO bookDTO, BookModel bookModel) {

    }

    @Override
    public void reConvert(BookModel bookModel, BookDTO bookDTO) {

    }
}
