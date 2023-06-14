package com.graphQl.graphQl.dao;

import com.graphQl.graphQl.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends JpaRepository<CategoryModel,Long> {
}
