package com.graphQl.graphQl.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Entity
@Data
@Table(name = "category")
public class CategoryModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private Long id;
    @Column(name = "category_name")
    private String name;
    @Column(name = "category_summary")
    private String summary;
    @Column(name = "category_books")
    @OneToMany(mappedBy = "categoryModel")
    private List<BookModel> bookModels;
    @Column(name = "category_another")
    @ManyToMany
    @JoinTable(
            name = "category_aother",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "another_id")
    )
    private List<AnotherModel> anotherModels;

}
