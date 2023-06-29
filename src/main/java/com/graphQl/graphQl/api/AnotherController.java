package com.graphQl.graphQl.api;

import com.graphQl.graphQl.facet.dto.AnotherDTO;
import com.graphQl.graphQl.model.AnotherModel;
import com.graphQl.graphQl.services.AnotherServices;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.plaf.PanelUI;
import java.util.List;

@Controller
@RequiredArgsConstructor

public class AnotherController {
    public final AnotherServices anotherServices;

    @QueryMapping
    public List<AnotherDTO> getAllAnother() {
        return anotherServices.getAll();
    }


    @MutationMapping
    public AnotherDTO createAnother(@Argument AnotherDTO anotherDTO) {
        return anotherServices.create(anotherDTO);
    }

    @QueryMapping
    public AnotherDTO getAnotherById(@Argument int id) {
        return anotherServices.getById(id);
    }


    @MutationMapping
    public String deleteAnother(@Argument int id) {
        return anotherServices.delete(id);
    }

    @MutationMapping
    public AnotherDTO updateAnother(@Argument AnotherDTO anotherDTO, @Argument int updateId) {
        return anotherServices.update(anotherDTO, updateId);

    }
}
