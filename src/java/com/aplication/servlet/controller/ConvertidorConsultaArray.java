package com.aplication.servlet.controller;

import com.aplication.servlet.conexion.Consultas;
import com.aplication.servlet.conexion.ConsultasBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConvertidorConsultaArray extends SQLException implements ConvertidorConsulta {
    
    private ResultSet resultado;
    private Consultas consulta;
    private ArrayList respuesta;
    
    public ConvertidorConsultaArray(){
        consulta = new Consultas();
        ArrayList<Object> respuesta = new ArrayList();
    }

    @Override
    public ArrayList listarComponenteEntrada() {
        resultado = consulta.listarComponenteEntrada();
        try {
            while(resultado.next()){
                for (int i = 1; i< 8; i++)
                respuesta.add(i,resultado.getString(i));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConvertidorConsultaArray.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public ArrayList listarComponenteSalida() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList listarComponenteUnidadCentral() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList listarImpresoras() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList listarImpresoraLaser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList listarImpresoraInyeccion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList listarventa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList detalleVenta(String cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
