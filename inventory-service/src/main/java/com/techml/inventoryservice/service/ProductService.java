package com.techml.inventoryservice.service;

import com.techml.inventoryservice.dto.ProductRequestDTO;
import com.techml.inventoryservice.entity.Category;
import com.techml.inventoryservice.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();

    Product getProductById(String productId);

    List<Category> getCategories();

    Category getCategoryById(Long categoryId);

    Product createProduct(ProductRequestDTO productRequestDTO);

    Product updateProduct(String productId, ProductRequestDTO productRequestDTO);

    void deleteProductById(String productId);
}
