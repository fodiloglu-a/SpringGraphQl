package com.graphQl.graphQl.services.impl;

import com.graphQl.graphQl.dao.CategoryDao;
import com.graphQl.graphQl.facet.converter.CategoryConverter;
import com.graphQl.graphQl.facet.dto.CategoryDTO;
import com.graphQl.graphQl.model.CategoryModel;
import com.graphQl.graphQl.services.CategoryServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CategoryServicesImp implements CategoryServices {
    private final CategoryDao categoryDao;
    private final CategoryConverter categoryConverter;
    @Override
    public List<CategoryDTO> getAll() {
        try {
            List<CategoryModel>categoryModels=categoryDao.findAll();
            if (categoryModels!=null){
                List<CategoryDTO>categoryDTOS= categoryConverter.convertAll(categoryModels);
                return categoryDTOS;
            }

        }catch (Exception e){
            e.getMessage();
        }
        return null;
    }

    @Override
    public CategoryDTO create(CategoryDTO categoryDTO) {
        try {
            CategoryModel categoryModel=categoryConverter.reConvert(new CategoryModel(),categoryDTO);
           if (categoryModel!=null){
               categoryDao.save(categoryModel);
               return categoryDTO;

           }


        }catch (Exception e){
            e.getMessage();
        }
        return null;
    }

    @Override
    public CategoryDTO getById(int id) {
        try {
            CategoryModel categoryModel=categoryDao.findById((long)id).get();
            if (categoryModel!=null){
                CategoryDTO categoryDTO=categoryConverter.convert(new CategoryDTO(),categoryModel);
                return categoryDTO;
            }
        }catch (Exception e){
            e.getMessage();
        }
        return null;
    }

    @Override
    public String delete(int id) {
        try {
            CategoryModel categoryModel=categoryDao.findById((long)id).get();
            if (categoryModel!=null){
                categoryDao.delete(categoryModel);
                return "Successful delete operations";
            }else {
                return "Can not found Category by id:"+id;
            }

        }catch (Exception e){
            e.getMessage();
        }
        return null;
    }

    @Override
    public CategoryDTO update(CategoryDTO categoryDTO, int updateId) {
        try {
            CategoryModel categoryModel=categoryDao.findById((long)updateId).get();
            if (categoryModel!=null){
                categoryModel=categoryConverter.reConvert(categoryModel,categoryDTO);
                categoryDao.save(categoryModel);
                return categoryDTO;
            }

        }catch (Exception e){
            e.getMessage();
        }
        return null;
    }
}
