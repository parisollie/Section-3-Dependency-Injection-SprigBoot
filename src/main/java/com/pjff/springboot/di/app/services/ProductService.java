package com.pjff.springboot.di.app.services;

import java.util.List;
import com.pjff.springboot.di.app.models.Product;

/*V-47,paso 1.6  puede interactuar con otros repositorios, accede a los datos ,
pero trabaja  con ellos, aceccede al repositorio pero trabaja con los datos*/
public interface ProductService {

    List<Product> findAll();

    Product findById(Long id);
}
