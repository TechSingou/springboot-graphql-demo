package com.techml.inventoryservice.service;

import com.techml.inventoryservice.dto.ProductRequestDTO;
import com.techml.inventoryservice.entity.Category;
import com.techml.inventoryservice.entity.Product;
import com.techml.inventoryservice.repository.CategoryRepository;
import com.techml.inventoryservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(String productId) {
        return productRepository.findById(productId).orElseThrow(
                () -> new RuntimeException(String.format("Product %s not found ", productId))
        );
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(
                () -> new RuntimeException(String.format("Category %s not found", categoryId))
        );
    }

    @Override
    public Product createProduct(ProductRequestDTO productRequestDTO) {
        Category category = categoryRepository.findById(productRequestDTO.categoryId()).orElse(null);
        Product productToSave = new Product();
        productToSave.setId(UUID.randomUUID().toString());
        productToSave.setName(productRequestDTO.name());
        productToSave.setPrice(productRequestDTO.price());
        productToSave.setQuantity(productRequestDTO.quantity());
        productToSave.setCategory(category);
        return productRepository.save(productToSave);
    }

    @Override
    public Product updateProduct(String productId, ProductRequestDTO productRequestDTO) {
        Category category = categoryRepository.findById(productRequestDTO.categoryId()).orElse(null);
        Product productToSave = new Product();
        productToSave.setId(productId);
        productToSave.setName(productRequestDTO.name());
        productToSave.setPrice(productRequestDTO.price());
        productToSave.setQuantity(productRequestDTO.quantity());
        productToSave.setCategory(category);
        return productRepository.save(productToSave);
    }

    @Override
    public void deleteProductById(String productId) {
        productRepository.deleteById(productId);
    }
}
