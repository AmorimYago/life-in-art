package com.shaulin.crud.dtos;

import java.math.BigDecimal;

public record ProductDto(String name, BigDecimal rating, String description, BigDecimal price, Integer stockQuantity) {
}
