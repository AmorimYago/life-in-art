package com.shaulin.crud.dtos;

import com.shaulin.crud.model.Group;

public record UserDto(String name, String cpf, String email, Group group, String password, Boolean status) {
}
