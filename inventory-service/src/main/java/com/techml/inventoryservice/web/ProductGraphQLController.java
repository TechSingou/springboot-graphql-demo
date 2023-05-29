package com.techml.inventoryservice.web;

import com.techml.inventoryservice.dto.ProductRequestDTO;
import com.techml.inventoryservice.entity.Category;
import com.techml.inventoryservice.entity.Product;
import com.techml.inventoryservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductGraphQLController {
    private ProductService productService;

    @Autowired
    public ProductGraphQLController(ProductService productService) {
        this.productService = productService;
    }


    @QueryMapping
    public List<Product> productList() {
        return productService.getProducts();
    }

    @QueryMapping
    public Product productById(@Argument String id) {
        return productService.getProductById(id);
    }

    @QueryMapping
    public List<Category> categories() {
        return productService.getCategories();
    }

    @QueryMapping
    public Category CategoryById(@Argument Long id) {
        return productService.getCategoryById(id);
    }

    @MutationMapping
    public Product saveProduct(@Argument ProductRequestDTO product) {
        return productService.createProduct(product);
    }

    @MutationMapping
    public Product updateProduct(@Argument String id, @Argument ProductRequestDTO product) {
        return productService.updateProduct(id, product);
    }

    @MutationMapping
    public void deleteProductById(@Argument String id) {
        productService.deleteProductById(id);
    }
}
