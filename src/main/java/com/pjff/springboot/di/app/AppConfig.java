package com.pjff.springboot.di.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

import com.pjff.springboot.di.app.repositories.ProductRepository;
import com.pjff.springboot.di.app.repositories.ProductRepositoryJson;

//V-61 
@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    // V-63
    @Value("classpath:json/product.json")
    private Resource resource;

    // Vid 63, ponemos Bean
    @Bean("productJson")
    // Vid 63
    ProductRepository productRepositoryJson() {
        return new ProductRepositoryJson();

    }

}
