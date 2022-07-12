package com.maybank.maybankassesment.entity;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class UserProfile {


    @Id
    @Column(updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String hashpassword;
    private String dob;
    private BigDecimal balance;

}
