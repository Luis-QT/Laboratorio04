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
public class ImpInyeccion extends Impresora{
    private String tipoCartucho;
    
    public ImpInyeccion(String tipoCartucho, int[] puertos, String tipoConector, String fabricante, String precio, String modelo) {
        super(puertos, tipoConector, fabricante, precio, modelo);
        this.tipoCartucho = tipoCartucho;
    }
    
    @Override
    public void imprimir() {
        System.out.println("Imprimiendo a laser");
    }
}
