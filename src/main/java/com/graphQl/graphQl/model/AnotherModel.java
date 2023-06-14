package com.graphQl.graphQl.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "another")
public class AnotherModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "another_id")
    private Long id;
    @Column(name = "another_name")
    private String name;
    @Column(name = "another_surname")
    private String surname;
    @Column(name = "another_address")
    private String address;
    @Column(name = "another_email")
    private String eMail;
    @Column(name = "another_resume")
    private String resume;
    @Column(name = "another_nationality")
    private String nationality;

    @ManyToMany
    private List<CategoryModel> categoryModels;

    @OneToMany(mappedBy = "anotherModel")
    private List<BookModel> bookModels=new ArrayList<>();

}
