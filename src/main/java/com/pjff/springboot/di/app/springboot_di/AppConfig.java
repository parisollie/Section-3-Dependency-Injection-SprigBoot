package com.pjff.springboot.di.app.springboot_di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

import com.pjff.springboot.di.app.repositories.ProductRepository;
import com.pjff.springboot.di.app.repositories.ProductRepositoryJson;

//vid 61 
@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    // Vid 63
    @Value("classpath:json/product.json")
    private Resource resource;

    // Vid 63, ponemos Bean
    @Bean("productJson")
    // Vid 63
    ProductRepository productRepositoryJson() {
        return new ProductRepositoryJson();

    }

}
