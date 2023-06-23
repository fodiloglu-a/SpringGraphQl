package com.graphQl.graphQl.api;

import com.graphQl.graphQl.facet.dto.AnotherDTO;
import com.graphQl.graphQl.model.AnotherModel;
import com.graphQl.graphQl.services.AnotherServices;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AnotherController {
    public final AnotherServices anotherServices;

    @QueryMapping
    public List<AnotherDTO>getAll(){
        return anotherServices.getAll();
    }
    @MutationMapping
    public AnotherModel create(@Argument AnotherDTO anotherDTO){
        AnotherModel anotherModel=new AnotherModel();
         anotherServices.create(anotherDTO);
         return anotherModel;
    }
}
