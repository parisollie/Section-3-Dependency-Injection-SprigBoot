package com.pjff.springboot.di.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pjff.springboot.di.app.models.Product;
import com.pjff.springboot.di.app.services.ProductService;

//V-48,paso 1.11, creamos el controlador.
@RestController
// ponemos nuestra ruta base
@RequestMapping("/api")
public class SomeController {
    /*
     * V-53, Autowired siempre es para inyectar, no nos llames ,nosotros te
     * llamamos.
     */
    @Autowired
    // Ponemos nuestro atributo.
    private ProductService service;

    // Lo mapeamos a la raiz
    @GetMapping
    // paso 1.12,devuelve una lista de productos ,e importamos.
    public List<Product> list() {
        return service.findAll();
    }

    // paso 1.13 ,Buscamos por id
    @GetMapping("/{id}")
    // Devuelve un objeto por id
    public Product show(@PathVariable Long id) {
        return service.findById(id);
    }
}
