package com.pjff.springboot.di.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pjff.springboot.di.app.models.Product;
import com.pjff.springboot.di.app.repositories.ProductRepository;

//V-55,paso 1.26 ponemos Service 
@Service
// V-51,Paso 1.21 IMPL-implementacion ,Vid 52 ,ponemos la interface
public class ProductServiceImpl implements ProductService {

    // V-61,inyectando por value, el valor viene de config.properties
    @Value("${config.price.tax}")
    private Double tax;

    // V-54,paso 1.24 inyectamos mediante interfaz
    private ProductRepository repository;

    /*
     * V-56,Paso 1.25 implementamos un constructor e inyectamos mediante el
     * V-58,paso 1.31,donde se inyecta ponemos la referencia con @Qualifier
     * V-63, ponemos el json
     */
    public ProductServiceImpl(@Qualifier("productJson") ProductRepository repository) {
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
             * V-50,Paso 1.16 creamos una instancia y devolvemos nuestro objeto clon
             * y devuelve una nueta instancia de producto
             */
            Product newProd = (Product) p.clone();
            /*
             * El clon devuelve una instancia de productos clonados y le modificamos el
             * precio
             * V-50,Paso 1.17 para que sean inmutable: new product
             * Paso 1.10, devolvemos un longvalue
             */
            newProd.setPrice(priceTax.longValue());
            // devolvemos el nuevo producto.
            return newProd;
            // metódo collect es lo que devuelve el mapa por eso lo convertimos
        }).collect(Collectors.toList());
    }

    @Override
    // V-47,paso 1.7
    public Product findById(Long id) {
        return repository.findById(id);
    }

}