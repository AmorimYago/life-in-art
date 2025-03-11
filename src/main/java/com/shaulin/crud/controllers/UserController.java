package com.shaulin.crud.controllers;

import com.shaulin.crud.dtos.UserDto;
import com.shaulin.crud.model.User;
import com.shaulin.crud.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository repository;

    @GetMapping
    public ResponseEntity getAll() {
        List<User> ListUsers = repository.findAll();
        /* A linha abaixo usa o ResponseEntity para fazer com que ele retorne uma retorne uma resposta do tipo OK (Código 200)
        Além disso o o corpo dessa reposta será a lista de usuarios cadastrados na base
         */
        return ResponseEntity.status(HttpStatus.OK).body(ListUsers);
    }

    /*
    O metodo abaixo será do tipo GET, porém ele vai passar um atributo do tipo id, então na URL da requisição da API
    A URL vai ficar por exemplo assim: localhost:8080/users/{id}
    Dessa forma estamos especificando qual é o registro especifico lá da base que queremos trazer na resposta
    */
    @GetMapping("/{id}") // Adicionando um novo parâmetro no metodo para receber o ID do usuario
    public ResponseEntity getById(@PathVariable(value = "id") Integer id) {
        // Resumidamente esse PathVariable serve para informar que o id é o mesmo do parametro
        Optional user = repository.findById(id);
        // Retorna uma resposta com o usuario encontrado (Código 200) ou um erro (Código 404) caso não seja encontrado
        if (user.isEmpty()) { // Verifica se não encontrou nada com o id
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(user.get());
    }

    @PostMapping
    public ResponseEntity save(@RequestBody UserDto dto) {
        // Implementar a lógica para salvar um novo user na base de dados
        // E retornar uma resposta de sucesso (Código 201)
        var user = new User();
        BeanUtils.copyProperties(dto, user);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete (@PathVariable(value = "id") Integer id) {
        Optional<User> user = repository.findById(id);
        if (user.isEmpty()) { // Verifica se o Id existe
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        repository.delete(user.get());
        return ResponseEntity.status(HttpStatus.OK).body("User deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity update (@PathVariable(value = "id") Integer id, @RequestBody UserDto dto) {
        Optional<User> user = repository.findById(id);
        if (user.isEmpty()) { // Verifica se o Id existe
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        var productModel = user.get();
        BeanUtils.copyProperties(dto, productModel);
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(productModel));
    }
}
