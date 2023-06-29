package com.graphQl.graphQl.services.impl;

import com.graphQl.graphQl.dao.AnotherDao;
import com.graphQl.graphQl.facet.converter.AnotherConverter;
import com.graphQl.graphQl.facet.dto.AnotherDTO;
import com.graphQl.graphQl.model.AnotherModel;
import com.graphQl.graphQl.services.AnotherServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnotherServicesImp implements AnotherServices {

    private final AnotherDao anotherDao;
    private final AnotherConverter anotherConverter;
    @Override
    public List<AnotherDTO> getAll() {
        List<AnotherDTO> anotherDTOS=new ArrayList<>();
        try {
            List<AnotherModel> anotherModels=anotherDao.findAll();
             anotherDTOS=anotherConverter.convertAll(anotherModels);

        }catch (Exception e){
            e.getMessage();
        }


        return anotherDTOS;
    }

    @Override
    public AnotherDTO create(AnotherDTO anotherDTO) {

        try {
            AnotherModel anotherModel=anotherDao.save(anotherConverter.reConvert(new AnotherModel(),anotherDTO));
            anotherDTO=anotherConverter.convert(new AnotherDTO(),anotherModel);
        }catch (Exception e){
            e.getMessage();
        }


        return anotherDTO;
    }

    @Override
    public AnotherDTO getById(int id) {
        AnotherDTO anotherDTO=new AnotherDTO();
        try {
            AnotherModel anotherModel=anotherDao.getById((long) id);
            if (anotherModel!=null){
                anotherDTO=anotherConverter.convert(anotherDTO,anotherModel);
                return anotherDTO;

            }
        }catch (Exception e){
          e.getMessage();
        }
    return null;
    }
 

    @Override
    public String delete(int id) {
        try {
            AnotherModel anotherModel=anotherDao.findById((long) id).get();
            if (anotherModel==null){
                return "Another is not found by"+id;
            }
            else {
                anotherDao.delete(anotherModel);
                return "Successful delete operation";
            }

        }catch (Exception e){
            e.getMessage();
        }
        return null;
    }

    @Override
    public AnotherDTO update(AnotherDTO anotherDTO, int updateId) {

        try {
            AnotherModel anotherModel=anotherDao.findById((long)updateId).get();
            if (anotherModel!=null){
                anotherModel=anotherConverter.reConvert(anotherModel,anotherDTO);
                anotherDao.save(anotherModel);
                anotherDTO=anotherConverter.convert(anotherDTO,anotherModel);

            }

        }catch (Exception e){
            e.getMessage();

        }
        return anotherDTO;
    }
 
}
