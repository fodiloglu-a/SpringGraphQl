package com.graphQl.graphQl.facet.converter;
import com.graphQl.graphQl.facet.dto.AnotherDTO;
import com.graphQl.graphQl.facet.populator.AnotherPopulator;
import com.graphQl.graphQl.model.AnotherModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AnotherConverter implements Convert<AnotherModel , AnotherDTO> {

    private final AnotherPopulator populator;


    @Override
    public void convert(AnotherModel anotherModel, AnotherDTO anotherDTO) {
        populator.rePopulate(anotherModel,anotherDTO);
    }

    @Override
    public void reConvert(AnotherDTO anotherDTO, AnotherModel anotherModel) {
        populator.populate(anotherDTO,anotherModel);

    }


}
