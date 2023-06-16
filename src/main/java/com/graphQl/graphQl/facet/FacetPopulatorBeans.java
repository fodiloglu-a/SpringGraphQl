package com.graphQl.graphQl.facet;

import com.graphQl.graphQl.facet.populator.AnotherPopulator;
import com.graphQl.graphQl.facet.populator.BookPopulator;
import com.graphQl.graphQl.facet.populator.CategoryPopulator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class FacetPopulatorBeans {

    @Bean
    @Lazy
    public AnotherPopulator anotherPopulator() {
        return new AnotherPopulator();
    }

    @Bean
    @Lazy
    public BookPopulator bookPopulator() {
        return new BookPopulator();
    }

    @Bean
    @Lazy
    public CategoryPopulator categoryPopulator() {
        return new CategoryPopulator();
    }
}
