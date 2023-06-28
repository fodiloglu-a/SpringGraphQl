package com.graphQl.graphQl.facet.converter;
import com.graphQl.graphQl.facet.dto.AnotherDTO;
import com.graphQl.graphQl.facet.populator.AnotherPopulator;
import com.graphQl.graphQl.model.AnotherModel;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


public class AnotherConverter implements Convert<AnotherDTO,AnotherModel> {

    @Resource
 
 
    private  AnotherPopulator populator;
 
 




    @Override
    public AnotherDTO convert(AnotherDTO anotherDTO, AnotherModel anotherModel) {
        return populator.populate(anotherDTO,anotherModel);
    }

    @Override
    public AnotherModel reConvert(AnotherModel anotherModel, AnotherDTO anotherDTO) {
        return populator.rePopulate(anotherModel,anotherDTO);
    }

    @Override
    public List<AnotherDTO> convertAll(List<AnotherModel> anotherModels) {
        AnotherDTO anotherDTO=new AnotherDTO();
        List<AnotherDTO> anotherDTOS=new ArrayList<>();
        List<AnotherModel> anotherModelList=anotherModels;
        for (AnotherModel anotherModel : anotherModelList) {

            try {
                anotherDTOS.add(populator.populate(anotherDTO,anotherModel));

            }catch (Exception e){
                e.getMessage();
            }

        }
        return anotherDTOS;
    }

    @Override
    public List<AnotherModel> reConvertAll(List<AnotherDTO> anotherDTOS) {
        List<AnotherDTO> anotherDTOList=anotherDTOS;
        List<AnotherModel> anotherModelList=new ArrayList<>();
        for (AnotherDTO anotherDTO : anotherDTOList) {
            AnotherModel anotherModel=null;
            try {
                anotherModelList.add(populator.rePopulate(anotherModel,anotherDTO));
            }catch (Exception e)
            {e.getMessage();}
        }
        return anotherModelList;

    }
}
