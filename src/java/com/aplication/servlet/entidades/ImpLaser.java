package com.aplication.servlet.entidades;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LuisQT
 */
public class ImpLaser extends Impresora{
    private String tipoToner;
    private int paginas;

    public ImpLaser(String tipoToner, int puerto, String tipoConector, String fabricante, String precio, String modelo) {
        super(puerto, tipoConector, fabricante, precio, modelo);
        this.tipoToner = tipoToner;
        paginas =0;
    }
    
    @Override
    public void imprimir() {
        System.out.println("Imprimiendo a laser");
    }

    @Override
    public String getNombreComponente() {
        return "Impresora Laser";
    }
    
}
