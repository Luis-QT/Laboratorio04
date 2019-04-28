/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplication.servlet.entidades;

/**
 *
 * @author LuisQT
 */
public abstract class Componente {
    private int id;
    private String fabricante;
    private String precio;
    private String modelo;

    public Componente(String fabricante, String precio, String modelo) {
        this.fabricante = fabricante;
        this.precio = precio;
        this.modelo = modelo;
    }

    public abstract String getNombreComponente();

    public String getDatos(){
        return getNombreComponente()+" "+fabricante+" "+modelo;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
}
