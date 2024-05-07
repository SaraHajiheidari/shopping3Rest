package com.shopping3.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String description;
    private double discount;
    private double prise;
    private double specialPrise;
    private Integer quantity;
    private String image;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<CartProduct> cartItems =new ArrayList<>();

    @OneToMany(mappedBy = "product" , cascade = {CascadeType.ALL})
    private List<OrderProduct> orderProducts = new ArrayList<>();



}
