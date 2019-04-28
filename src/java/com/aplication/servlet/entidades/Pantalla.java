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
public class Pantalla extends DispSalida{
    
    private String pixeles;

    public Pantalla(String pixeles, int puerto, String tipoConector, String fabricante, String precio, String modelo) {
        super(puerto, tipoConector, fabricante, precio, modelo);
        this.pixeles = pixeles;
    }

    public String getPixeles() {
        return pixeles;
    }

    public void setPixeles(String pixeles) {
        this.pixeles = pixeles;
    }

    @Override
    public String getNombreComponente() {
        return "Pantalla";
    }
    
}
