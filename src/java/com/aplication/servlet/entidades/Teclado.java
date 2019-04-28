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
public class Teclado extends DispEntrada{
    
    public Teclado(int puerto, String tipoConector, String fabricante, String precio, String modelo) {
        super(puerto, tipoConector, fabricante, precio, modelo);
    }
    private String teclas;

    public Teclado(String teclas, int puerto, String tipoConector, String fabricante, String precio, String modelo) {
        super(puerto, tipoConector, fabricante, precio, modelo);
        this.teclas = teclas;
    }

    public String getTeclas() {
        return teclas;
    }

    public void setTeclas(String teclas) {
        this.teclas = teclas;
    }

    @Override
    public String getNombreComponente() {
        return "Teclado";
    }
    
}
