package com.pjff.springboot.di.app.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pjff.springboot.di.app.models.Product;

//V-57,paso 1.27 creamos el ProductRepositoryFoo e implemantamos la interfaz
//V-58,paso 1.33 le llamamos ,"productFoo"
@Repository("productFoo")
public class ProductRepositoryFoo implements ProductRepository {

    // Paso 1.28
    @Override
    public List<Product> findAll() {
        // singletonList ,un solo elemento
        return Collections.singletonList(new Product(1L, "Monitor Asus 27", 600L));
    }

    // Paso 1.29
    @Override
    public Product findById(Long id) {
        return new Product(id, "Monitor Asus 27", 600L);
    }

}