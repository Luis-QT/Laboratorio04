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
public abstract class DispSalida extends Periferico{
    
    public DispSalida(int puerto, String tipoConector, String fabricante, String precio, String modelo) {
        super(puerto, tipoConector, fabricante, precio, modelo);
    }
    
}
