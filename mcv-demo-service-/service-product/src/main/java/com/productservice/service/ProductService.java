package com.productservice.service;

import com.productservice.poji.Product;

import java.util.List;

public interface ProductService {
    void save(Product product);

    Product getById(Long id);

    void updateProduct(Product product);

    void deleteProduct(Long id);
}
