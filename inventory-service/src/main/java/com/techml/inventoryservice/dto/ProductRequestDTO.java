package com.techml.inventoryservice.dto;

// record : Java class with attribute and getters
public record ProductRequestDTO(
        String id,
        String name,
        double price,
        int quantity,
        Long categoryId
) {
}

