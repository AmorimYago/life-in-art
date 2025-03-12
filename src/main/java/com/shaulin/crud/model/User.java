package com.shaulin.crud.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "users")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Integer id;
    private @Getter @Setter String name;
    private @Getter @Setter String cpf;
    private @Getter @Setter String email;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private @Getter @Setter Group group;
    private @Getter @Setter String password;
    private @Getter @Setter Boolean status = true;

}
