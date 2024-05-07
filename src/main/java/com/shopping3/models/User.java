package com.shopping3.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String firstName;
    private String familyName;
    private String password;
    private String mobileNumber;
    @ManyToMany
    @JoinTable(name = "user_role" ,
            joinColumns = @JoinColumn(name = "user_id") ,
            inverseJoinColumns = @JoinColumn(name ="role_id"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "user" , fetch = FetchType.EAGER)
    private List<Address> addresses = new ArrayList<>();

    @OneToOne(mappedBy = "user")
    private Cart cart;

}
