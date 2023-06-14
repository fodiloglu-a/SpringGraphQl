package com.graphQl.graphQl.facet.converter;

import com.graphQl.graphQl.facet.dto.BookDTO;
import com.graphQl.graphQl.facet.populator.BookPopulator;
import com.graphQl.graphQl.model.BookModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BookConverter  implements Convert<BookDTO, BookModel> {


    private final BookPopulator populator;
    @Override
    public BookDTO convert(BookDTO bookDTO, BookModel bookModel) {
        return populator.populate(bookDTO,bookModel);
    }

    @Override
    public BookModel reConvert(BookModel bookModel, BookDTO bookDTO) {
        return populator.rePopulate(bookModel,bookDTO);
    }

    @Override
    public List<BookDTO> convertAll(List<BookModel> bookModels) {
        List<BookDTO> bookDTOS=new ArrayList<>();
        List<BookModel> bookModelList=bookModels;
        for (BookModel bookModel : bookModelList) {
            BookDTO bookDTO=null;
            bookDTOS.add(populator.populate(bookDTO,bookModel));
        }
        return bookDTOS;
    }

    @Override
    public List<BookModel> reConvertAll(List<BookDTO> bookDTOS) {
        List<BookModel> bookModelList=new ArrayList<>();
        List<BookDTO> bookDTOList=bookDTOS;

        for (BookDTO bookDTO : bookDTOList) {
            BookModel bookM=null;
            bookModelList.add(populator.rePopulate(bookM,bookDTO));
        }
        return bookModelList;
    }
}
