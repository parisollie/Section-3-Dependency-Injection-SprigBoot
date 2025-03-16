package com.pjff.springboot.di.app.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.pjff.springboot.di.app.models.Product;

/*V-59, deja de ser singleton 
  @RequestScope
  V-58, al tener dos repositorios ,primary indicia que es el principal.*/
@Primary
/*
 * V-55, Repository es un estereotipo, tambien es un componente de acceso a
 * datos
 * V-58, le llamamos al repositorio productList, para que no sea un nombre tan
 * largo.
 */
@Repository("productList")
// V-51 ,Paso 1.19,Impl ,implementacion y le implementamos la interfaz
public class ProductRepositoryImpl implements ProductRepository {
    // tenemos una lista de tipo product
    private List<Product> data;

    public ProductRepositoryImpl() {
        // V-45, creamos los objetos
        this.data = Arrays.asList(
                // Como son de tipo long le ponemos (L)
                new Product(1L, "Memoria corsair 32", 300L),
                new Product(2L, "Cpu Intel Core i9", 850L),
                new Product(3L, "Teclado Razer Mini 60%", 180L),
                new Product(4L, "Motherboard Gigabyte", 490L));
    }

    /*
     * V-51,Paso 1.20 la interfaz pone override ,que es una implementacion de la
     * interfaz que es una sobreescritura.
     */
    @Override
    // V-45, ponemos nuestros metódos.
    public List<Product> findAll() {
        return data;
    }

    @Override
    // V-46
    public Product findById(Long id) {
        // Con filter, ponemos un pedricado ,sino encuentra el producto regresa nulo.
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

}