package com.productservice.service.Impl;

import com.productservice.mqpper.ProductMapper;
import com.productservice.poji.Product;
import com.productservice.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;
    //添加产品
    @Override
    public void save(Product product) {
        productMapper.saveInsert(product);
    }

    //浏览产品
    @Override
    public Product getById(Long id) {
        Product product = productMapper.getById(id);
        return product;
    }

    //修改产品
    @Override
    public void updateProduct(Product product) {
        productMapper.updateProduct(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productMapper.deleteById(id);
    }
}
