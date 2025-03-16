package com.pjff.springboot.di.app.repositories;

import java.util.List;

import com.pjff.springboot.di.app.models.Product;

//Vid 51, creamos nuestra interface
public interface ProductRepository {

    //Los métodos que va implementar.¿,por defecto son públicos.
    List<Product> findAll();

    Product findById(Long id);
}

