package com.pjff.springboot.di.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pjff.springboot.di.app.models.Product;
import com.pjff.springboot.di.app.repositories.ProductRepository;

//Vid 55,ponemos Service 
@Service
// Vid 51 IMPL-implementacion ,Vid 52 ,ponemos la interface
public class ProductServiceImpl implements ProductService {

    // Vid 61,inyectando por value, el valor viene de config.properties
    @Value("${config.price.tax}")
    private Double tax;

    // inyectamos mediante interfaz
    private ProductRepository repository;

    // Vid 56, implementamos un constructor
    // Vid 58,donde se inyecta ponemos la referencia con @Qualifier
    // Vid 63, ponem,os el json
    public ProductServiceImpl(@Qualifier("productJson") ProductRepository repository) {
        // inyectando por constructor.
        this.repository = repository;

    }

    @Override
    // V-47,paso 1.8
    public List<Product> findAll() {
        /*
         * El find devuelve una lista de productos ,el map manipula el objeto ,iteramos
         * cada objeto producto.El mapa devuelve un stream
         */
        return repository.findAll().stream().map(p -> {
            // V-47,paso 1.9, creamos el impuesto
            Double priceTax = p.getPrice() * tax;
            /*
             * Vid 50, creamos una instancia y devolvemos nuestro objeto clon
             * y devuelve una nueta instancia de producto
             */
            Product newProd = (Product) p.clone();
            /*
             * el clon devuelve una instancia de productos clonados y le modificamos el
             * precio
             * Vid 50,para que sean inmutable: new product
             * paso 1.10, devolvemos un longvalue
             */
            newProd.setPrice(priceTax.longValue());
            // devolvemos el objeto modificado
            return newProd;
            // metódo collect es lo que devuelve el mapa por eso lo convertimos
        }).collect(Collectors.toList());
    }

    @Override
    // Vid 47,paso 1.7
    public Product findById(Long id) {
        return repository.findById(id);
    }

}
