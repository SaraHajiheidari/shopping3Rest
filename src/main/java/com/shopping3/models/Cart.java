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
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    private double totalPrice;

    @OneToMany(mappedBy ="cart" )
    private List<CartProduct> cartItem = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
