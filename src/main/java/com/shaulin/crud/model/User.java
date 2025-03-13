package com.shaulin.crud.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "users")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    public String name;
    private String cpf;
    public String email;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;
    private String password;
    public Boolean status = true;

}
