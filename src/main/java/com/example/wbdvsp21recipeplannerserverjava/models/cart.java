package com.example.wbdvsp21recipeplannerserverjava.models;

import javax.persistence.*;

@Entity
@Table(name="carts")
public class cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;



}
