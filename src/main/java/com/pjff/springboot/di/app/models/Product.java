package com.pjff.springboot.di.app.models;

//V-45,Paso 1.0 creamos la clase productos. 
//V-50,Paso 1.14 ponemos implements Cloneable
public class Product implements Cloneable {

    // Paso 1.1 ponemos sus atributos
    private Long id;
    private String name;
    private Long price;

    /*
     * Paso 1.3, Constructor vacío en caso de que queramos crear la instancia con
     * new
     * y pasar
     * parámetros con set
     */
    public Product() {
    }

    // Generamos su constructor
    public Product(Long id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // --------Paso 1.2,ponemos sus getters andsetters.-----------------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    // V-50,paso 1.15
    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            // Retornamos un objeto producto, si ocurre un error
            return new Product(this.getId(), this.getName(), getPrice());
        }
    }

}