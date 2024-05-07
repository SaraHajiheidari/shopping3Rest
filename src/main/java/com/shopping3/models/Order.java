package com.shopping3.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private String email;
    private LocalDate orderDate;
    private double totalAmount;
    private String orderStatus;

    @OneToMany(mappedBy = "order" , cascade = {CascadeType.ALL})
    private List<OrderProduct> orderProducts = new ArrayList<>();

    @OneToOne   //har orderi ye pardacht dare;har pardacht ham vase ye ordere
    @JoinColumn(name = "payment_id")
    private Payment payment;

}
