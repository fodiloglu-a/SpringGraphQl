package com.graphQl.graphQl.dao;

import com.graphQl.graphQl.model.AnotherModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface AnotherDao extends JpaRepositoryImplementation<AnotherModel,Long>,JpaRepository<AnotherModel,Long>{
}
