package com.aplication.servlet.conexion;

import java.sql.ResultSet;

public interface ConsultasBD {

    public ResultSet listarComponenteEntrada();
    public ResultSet listarComponenteSalida();
    public ResultSet listarComponenteUnidadCentral();
    public ResultSet listarImpresoras();
    public ResultSet listarImpresoraLaser();
    public ResultSet listarImpresoraInyeccion();
    public ResultSet listarventa();
    public ResultSet detalleVenta(String cliente);
    
}
