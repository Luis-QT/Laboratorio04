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
    private int puerto;
    private String tipoConector;

    public Periferico(String fabricante, String precio, String modelo) {
        super(fabricante, precio, modelo);
    }
    
    public Periferico(int puerto, String tipoConector, String fabricante, String precio, String modelo) {
        super(fabricante, precio, modelo);
        this.puerto = puerto;
        this.tipoConector = tipoConector;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public String getTipoConector() {
        return tipoConector;
    }

    public void setTipoConector(String tipoConector) {
        this.tipoConector = tipoConector;
    }
    
    @Override
    public String getDatos(){
        String modelo = super.getModelo();
        String fabricante = super.getFabricante();
        return getNombreComponente()+" "+fabricante+" "+modelo+" .Puerto : "+puerto+" .Conector: "+tipoConector;
    }
    
    
}
