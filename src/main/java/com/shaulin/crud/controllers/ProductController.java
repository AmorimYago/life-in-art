package com.shaulin.crud.controllers;

import com.shaulin.crud.dtos.ProductDto;
import com.shaulin.crud.model.Product;
import com.shaulin.crud.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired  // Isso significa obter o bean chamado productRepository
    // Que é gerado automaticamente pelo Spring, nós o usaremos para realizar operações no banco de dados.
    ProductRepository repository;

    @GetMapping
    public ResponseEntity getAll() {
        List<Product> ListProducts = repository.findAll();
        /* A linha abaixo usa o ResponseEntity para fazer com que ele retorne uma retorne uma resposta do tipo OK (Código 200)
        Além disso o o corpo dessa reposta será a lista de produtos cadastrados na base
         */
        return ResponseEntity.status(HttpStatus.OK).body(ListProducts);
    }

    /*
    O metodo abaixo será do tipo GET, porém ele vai passar um atributo do tipo id, então na URL da requisição da API
    A URL vai ficar por exemplo assim: localhost:8080/products/{id}
    Dessa forma estamos especificando qual é o registro especifico lá da base que queremos trazer na resposta
    */
    @GetMapping("/{id}") // Adicionando um novo parâmetro no metodo para receber o ID do produto
    public ResponseEntity getById(@PathVariable(value = "id") Integer id) {
        // Resumidamente esse PathVariable serve para informar que o id é o mesmo do parametro
        Optional product = repository.findById(id);
        // Retorna uma resposta com o produto encontrado (Código 200) ou um erro (Código 404) caso não seja encontrado
        if (product.isEmpty()) { // Verifica se não encontrou nada com o id
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        return ResponseEntity.status(HttpStatus.FOUND).body(product.get());
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ProductDto dto) {
        // Implementar a lógica para salvar um novo produto na base de dados
        // E retornar uma resposta de sucesso (Código 201)
        var product = new Product();
        BeanUtils.copyProperties(dto, product);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete (@PathVariable(value = "id") Integer id) {
        Optional<Product> product = repository.findById(id);
        if (product.isEmpty()) { // Verifica se o Id existe
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        repository.delete(product.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted");
    }

    @PutMapping("/{id}")
    public ResponseEntity update (@PathVariable(value = "id") Integer id, @RequestBody ProductDto dto) {
        Optional<Product> product = repository.findById(id);
        if (product.isEmpty()) { // Verifica se o Id existe
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        var productModel = product.get();
        BeanUtils.copyProperties(dto, productModel);
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(productModel));
    }

}
