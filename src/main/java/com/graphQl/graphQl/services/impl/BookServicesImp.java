package com.graphQl.graphQl.services.impl;

import com.graphQl.graphQl.dao.BookDao;
import com.graphQl.graphQl.facet.converter.BookConverter;
import com.graphQl.graphQl.facet.dto.AnotherDTO;
import com.graphQl.graphQl.facet.dto.BookDTO;
import com.graphQl.graphQl.model.BookModel;
import com.graphQl.graphQl.services.BookServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class BookServicesImp implements BookServices {
    private final BookDao bookDao;
    private final BookConverter bookConverter;
    @Override
    public List<BookDTO> getAll() {
        List<BookDTO> bookDTOS=new ArrayList<>();
        try {
            List<BookModel> bookModels=bookDao.findAll();
            bookDTOS=bookConverter.convertAll(bookModels);

        }catch (Exception e){
            e.getMessage();
        }


        return bookDTOS;
    }

    @Override
    public BookDTO create(BookDTO bookDTO) {

        try {
            BookModel bookModel=bookDao.save(bookConverter.reConvert(new BookModel(),bookDTO));
            bookDTO=bookConverter.convert(bookDTO,bookModel);
        }catch (Exception e){
            e.getMessage();
        }


        return bookDTO;
    }

    @Override
    public BookDTO getById(int updateBookId) {
        BookDTO bookDTO=new BookDTO();
        try {
            BookModel bookModel=bookDao.getById((long) updateBookId);
            if (bookModel!=null){
                bookDTO=bookConverter.convert(bookDTO,bookModel);
                return bookDTO;

            }
        }catch (Exception e){
            e.getMessage();
        }
        return null;
    }

    @Override
    public String delete(int deleteBookId) {
        try {
            BookModel bookModel=bookDao.findById((long) deleteBookId).get();
            if (bookModel==null){
                return "Another is not found by"+deleteBookId;
            }
            else {
                bookDao.delete(bookModel);
                return "Successful delete operation";
            }

        }catch (Exception e){
            e.getMessage();
        }
        return null;
    }

    @Override
    public BookDTO update(BookDTO bookDTO, int updateBookId) {

        try {
            BookModel bookModel =bookDao.findById((long)updateBookId).get();
            if (bookModel !=null){
                bookModel =bookConverter.reConvert(bookModel,bookDTO);
                bookDao.save(bookModel);
                bookDTO=bookConverter.convert(bookDTO, bookModel);

            }

        }catch (Exception e){
            e.getMessage();

        }
        return bookDTO;
    }

}

