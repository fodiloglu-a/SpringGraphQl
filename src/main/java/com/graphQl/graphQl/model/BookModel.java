package com.graphQl.graphQl.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "book")
@Data
public class BookModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private Long id;
    @Column(name = "book_name")
    private String name;
    @Column(name = "book_summary")
    private String summary;
    @Column(name = "book_page_count")
    private int pageCount;
    @Column(name = "book_publication_date")
    private Date publicationDate;

    @ManyToOne
    @JoinColumn(name = "another_id",nullable = false)
    private AnotherModel anotherModel;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryModel categoryModel;





}
