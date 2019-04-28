/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplication.servlet.entidades;

import java.util.ArrayList;

/**
 *
 * @author LuisQT
 */
public class Ordenador {
    private ArrayList<Componente> componentes;

    public Ordenador(ArrayList<Componente> componentes) {
        this.componentes = componentes;
    }

    public ArrayList<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(ArrayList<Componente> componentes) {
        this.componentes = componentes;
    }
    
}
