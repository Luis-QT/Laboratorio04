package com.aplication.servlet.entidades;

public class PantallaTactil extends Periferico{
    
    public PantallaTactil(int puerto, String tipoConector, String fabricante, String precio, String modelo) {
        super(puerto, tipoConector, fabricante, precio, modelo);
    }

    @Override
    public String getNombreComponente() {
        return "Pantalla tactil";
    }
    
}
