package com.graphQl.graphQl.dao;

import com.graphQl.graphQl.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends JpaRepository<BookModel,Long> {
}
