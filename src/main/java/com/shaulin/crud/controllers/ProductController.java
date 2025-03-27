package com.shaulin.crud.controllers;

import com.shaulin.crud.model.Product;
import com.shaulin.crud.model.ProductImage;
import com.shaulin.crud.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    // Lista todos os produtos
    @GetMapping
    public String listProducts(Model model) {
        List<Product> products = repository.findAll();
        products.forEach(product -> product.getImages().forEach(img ->
                img.setBase64Image(Base64.getEncoder().encodeToString(img.getImage()))
        ));
        model.addAttribute("products", products);
        return "loja";
    }

    // Obtém um produto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        Optional<Product> productOpt = repository.findById(id);

        if (productOpt.isPresent()) {
            Product product = productOpt.get();

            product.getImages().forEach(img ->
                    img.setBase64Image(Base64.getEncoder().encodeToString(img.getImage())));

            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }

    // Adiciona um novo produto com várias imagens
    @PostMapping
    public String createProduct(@RequestParam("name") String name,
                                @RequestParam("rating") BigDecimal rating,
                                @RequestParam("description") String description,
                                @RequestParam("price") BigDecimal price,
                                @RequestParam("stockQuantity") Integer stockQuantity,
                                @RequestParam("image") MultipartFile[] images) throws IOException {

        Product product = new Product();
        product.setName(name);
        product.setRating(rating);
        product.setDescription(description);
        product.setPrice(price);
        product.setStockQuantity(stockQuantity);
        product.setStatus(true);

        for (MultipartFile file : images) {
            ProductImage productImage = new ProductImage();
            productImage.setImage(file.getBytes());
            productImage.setProduct(product);
            product.getImages().add(productImage);
        }

        repository.save(product);
        return "redirect:/products";
    }

    // Atualiza um produto existente
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = {"multipart/form-data"})
    public ResponseEntity<String> updateProduct(@PathVariable Integer id,
                                                @RequestParam("name") String name,
                                                @RequestParam("rating") BigDecimal rating,
                                                @RequestParam("description") String description,
                                                @RequestParam("price") BigDecimal price,
                                                @RequestParam("stockQuantity") Integer stockQuantity,
                                                @RequestParam(value = "image", required = false) MultipartFile[] images) throws IOException {
        Optional<Product> existingProduct = repository.findById(id);
        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setName(name);
            product.setRating(rating);
            product.setDescription(description);
            product.setPrice(price);
            product.setStockQuantity(stockQuantity);

            if (images != null && images.length > 0 && !images[0].isEmpty()) {
                product.getImages().clear();
                for (MultipartFile file : images) {
                    ProductImage productImage = new ProductImage();
                    productImage.setImage(file.getBytes());
                    productImage.setProduct(product);
                    product.getImages().add(productImage);
                }
            }

            repository.save(product);
            return ResponseEntity.ok("Produto atualizado com sucesso!");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
    }


    // Exclui um produto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Altera o status do produto (habilitado/desabilitado)
    @PutMapping("/{id}/toggle-status")
    public ResponseEntity<String> toggleProductStatus(@PathVariable Integer id) {
        Optional<Product> existingProduct = repository.findById(id);

        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();

            // Se status for null, define um valor padrão (true)
            if (product.getStatus() == null) {
                product.setStatus(true);
            } else {
                product.setStatus(!product.getStatus()); // Alterna entre true e false
            }

            repository.save(product);
            return ResponseEntity.ok("Status atualizado para: " + product.getStatus());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
    }

}