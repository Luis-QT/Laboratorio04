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
public abstract class Periferico extends Componente{
    private int[] puertos;
    private String tipoConector;

    public Periferico(String fabricante, String precio, String modelo) {
        super(fabricante, precio, modelo);
    }

    public Periferico(int[] puertos, String tipoConector, String fabricante, String precio, String modelo) {
        super(fabricante, precio, modelo);
        this.puertos = puertos;
        this.tipoConector = tipoConector;
    }

    public int[] getPuertos() {
        return puertos;
    }

    public void setPuertos(int[] puertos) {
        this.puertos = puertos;
    }

    public String getTipoConector() {
        return tipoConector;
    }

    public void setTipoConector(String tipoConector) {
        this.tipoConector = tipoConector;
    }
    
    
}
