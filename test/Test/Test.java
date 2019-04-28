/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import com.aplication.servlet.entidades.Componente;
import com.aplication.servlet.entidades.Teclado;
import java.util.ArrayList;

/**
 *
 * @author LuisQT
 */
public class Test {
    public static void main(String[] args) {
        
        Teclado teclado = new Teclado(1, "Cable ps2", "asus", "13.56", "DHSFSJB");
        Teclado raton = new Teclado(2, "Cable usb", "lenovo", "13.56", "VV66s");
        
        ArrayList<Componente> componente = new ArrayList();
        
        componente.add(teclado);
        componente.add(raton);
        
        componente.stream().forEach((Componente c) -> {
            System.out.println("Fabricante : "+ c.getFabricante());
        });
        
    }
}
