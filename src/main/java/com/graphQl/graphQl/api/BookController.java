package com.graphQl.graphQl.api;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphQl.graphQl.facet.dto.BookDTO;
import com.graphQl.graphQl.services.BookServices;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor

public class BookController implements GraphQLMutationResolver, GraphQLQueryResolver {

    private final BookServices bookServices;

    @QueryMapping
    public List<BookDTO> getAllBook() {
        return bookServices.getAll();
    }

    @MutationMapping
    public BookDTO createBook(@Argument BookDTO bookDTO) {
        return bookServices.create(bookDTO);
    }

    @QueryMapping
    public BookDTO getBookById(@Argument int id) {
        return bookServices.getById(id);
    }

    @MutationMapping
    public String deleteBook(@Argument int deleteBookId) {
        return bookServices.delete(deleteBookId);
    }

    @MutationMapping
    public BookDTO updateBook(@Argument BookDTO bookDTO, int updateBookId) {
        return bookServices.update(bookDTO, updateBookId);
    }


}
