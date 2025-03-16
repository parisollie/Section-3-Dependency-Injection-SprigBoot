package com.pjff.springboot.di.app.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pjff.springboot.di.app.models.Product;

//Vid 62
public class ProductRepositoryJson implements ProductRepository {

    private List<Product> list;

    public ProductRepositoryJson() {
        Resource resource = new ClassPathResource("json/product.json");
        // Vid 63
        readValueJson(resource);
    }

    public ProductRepositoryJson(Resource resource) {
        readValueJson(resource);
    }

    private void readValueJson(Resource resource) {
        // comvertimos a un objeto de java
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // convertimos a una lista
            // Vid 64 objectMapper.readValue(resource.getInputStream()
            list = Arrays.asList(objectMapper.readValue(resource.getInputStream(), Product[].class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Vid 62

    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    // V-46,paso 1.4, creamos el repositorio
    public Product findById(Long id) {
        // Vid 63,.orElseThrow() le mandamos una excepcion
        /*
         * V-46,paso 1.5 con filter se implementa un predicate(es una condicion
         * booleana
         * ),si se cumple obtenemos ese elemento, se emite cada producto con funcion
         * lambda y con el id que pasamos por párametro y lo obtenemos.
         */
        return list.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }

}