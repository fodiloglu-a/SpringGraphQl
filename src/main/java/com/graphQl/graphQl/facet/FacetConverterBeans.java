package com.graphQl.graphQl.facet;

import com.graphQl.graphQl.facet.converter.AnotherConverter;
import com.graphQl.graphQl.facet.converter.BookConverter;
import com.graphQl.graphQl.facet.converter.CategoryConverter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


@Component
public class FacetConverterBeans {

    @Bean
    @Lazy
    public AnotherConverter anotherConverter() {
        return new AnotherConverter();
    }

    @Bean
    @Lazy
    public BookConverter bookConverter() {
        return new BookConverter();
    }

    @Bean
    @Lazy
    public CategoryConverter categoryConverter() {
        return new CategoryConverter();
    }
}
