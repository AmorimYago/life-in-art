package com.shaulin.crud.model;

import jakarta.persistence.*;
import lombok.*;


import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "product")
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Integer id;
    private @Getter @Setter String name;
    private @Getter @Setter BigDecimal rating;
    private @Getter @Setter String description;
    private @Getter @Setter BigDecimal price;
    private @Getter @Setter Integer stockQuantity;

}
