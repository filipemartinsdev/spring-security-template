package com.spring.app.service;

import com.spring.app.model.entity.Product;
import com.spring.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return (List<Product>) this.productRepository.findAll();
    }
}
