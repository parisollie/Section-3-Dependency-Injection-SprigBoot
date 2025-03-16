package com.pjff.springboot.di.app.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pjff.springboot.di.app.models.Product;


//Vid 57,
//Vid 58 le llamamos ,"productFoo"
@Repository("productFoo")
public class ProductRepositoryFoo implements ProductRepository {

    @Override
    public List<Product> findAll() {
        //singletonList ,un solo elemento
        return Collections.singletonList(new Product(1L, "Monitor Asus 27", 600L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(id, "Monitor Asus 27", 600L);
    }
    
}

