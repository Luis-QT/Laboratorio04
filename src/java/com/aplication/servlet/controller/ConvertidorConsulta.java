package com.aplication.servlet.controller;

import com.aplication.servlet.conexion.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public interface ConvertidorConsulta {

    public ArrayList listarComponenteEntrada();
    public ArrayList listarComponenteSalida();
    public ArrayList listarComponenteUnidadCentral();
    public ArrayList listarImpresoras();
    public ArrayList listarImpresoraLaser();
    public ArrayList listarImpresoraInyeccion();
    public ArrayList listarventa();
    public ArrayList detalleVenta(String cliente);
    
}
