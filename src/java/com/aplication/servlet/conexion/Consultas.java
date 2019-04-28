package com.aplication.servlet.conexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Consultas implements ConsultasBD{

    private java.sql.Connection _connection;
    
    public Consultas(){
        JDBCDataAccessClass connection = new JDBCDataAccessClass();
        connection.initialize();
        _connection = connection.getInstance();
    }

    @Override
    public ResultSet listarComponenteEntrada() {
        Statement statement = null;
        try {
            statement = _connection .createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM componenteentrada;");
            return resultSet;
        } catch (SQLException e) {
            System.out.println("Error crear la sentencia " + e.getMessage());
        }
        return null;
    }

    @Override
    public ResultSet listarComponenteSalida() {
        Statement statement = null;
        try {
            statement = _connection .createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM componentesalida;");
            return resultSet;
        } catch (SQLException e) {
            System.out.println("Error crear la sentencia " + e.getMessage());
        }
        return null;
    }

    @Override
    public ResultSet listarComponenteUnidadCentral() {
        Statement statement = null;
        try {
            statement = _connection .createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM componenteuc;");
            return resultSet;
        } catch (SQLException e) {
            System.out.println("Error crear la sentencia " + e.getMessage());
        }
        return null;
    }

    @Override
    public ResultSet listarImpresoras() {
        Statement statement = null;
        try {
            statement = _connection .createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT tipoimpresora.idTipoImpresora,"
                    + "componentesalida.fabricante, componentesalida.modelo, componentesalida.precio,"
                    + "componentesalida.puerto, componentesalida.costo"
                    + "FROM componentesalida INNER JOIN tipoimpresora"
                    + "ON tipoimpresora.ComponenteSalida_idComponenteSalida = componentesalida.idComponenteSalida;");
            return resultSet;
        } catch (SQLException e) {
            System.out.println("Error crear la sentencia " + e.getMessage());
        }
        return null;
    }

    @Override
    public ResultSet listarImpresoraLaser() {
        Statement statement = null;
        try {
            statement = _connection .createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT tipoimpresora.idTipoImpresora,"
                    + "componentesalida.fabricante, componentesalida.modelo, componentesalida.precio,"
                    + "componentesalida.puerto, componentesalida.costo, toner.nombre, toner.numeroPagina"
                    + "FROM componentesalida INNER JOIN tipoimpresora"
                    + "ON tipoimpresora.ComponenteSalida_idComponenteSalida = componentesalida.idComponenteSalida"
                    + "INNER JOIN laser ON laser.TipoImpresora_idTipoImpresora = tipoimpresora.idTipoImpresora"
                    + "INNER JOIN toner ON toner.Laser_idLaser = laser.idLaser;");
            return resultSet;
        } catch (SQLException e) {
            System.out.println("Error crear la sentencia " + e.getMessage());
        }
        return null;
    }

    @Override
    public ResultSet listarImpresoraInyeccion() {
        Statement statement = null;
        try {
            statement = _connection .createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT tipoimpresora.idTipoImpresora,"
                    + "componentesalida.fabricante, componentesalida.modelo, componentesalida.precio,"
                    + "componentesalida.puerto, componentesalida.costo, tipocartucho.nombre"
                    + "FROM componentesalida INNER JOIN tipoimpresora"
                    + "ON tipoimpresora.ComponenteSalida_idComponenteSalida = componentesalida.idComponenteSalida"
                    + "INNER JOIN inyeccion ON inyeccion.TipoImpresora_idTipoImpresora = tipoimpresora.idTipoImpresora"
                    + "INNER JOIN tipocartucho ON tipocartucho.Inyeccion_idInyeccion = inyeccion.idInyeccion;");
            return resultSet;
        } catch (SQLException e) {
            System.out.println("Error crear la sentencia " + e.getMessage());
        }
        return null;
    }

    @Override
    public ResultSet listarventa() {
        Statement statement = null;
        try {
            statement = _connection .createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT venta.idVenta, cliente.Nombre,"
                    + "cliente.Apellido, venta.fecha, venta.costoTotal FROM venta"
                    + "INNER JOIN cliente ON venta.Cliente_idCliente = cliente.idCliente;");
            return resultSet;
        } catch (SQLException e) {
            System.out.println("Error crear la sentencia " + e.getMessage());
        }
        return null;
    }
    
    @Override
    public ResultSet detalleVenta(String clienteNombre) {
        Statement statement = null;
        try {
            statement = _connection .createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT cliente.idCliente,"
                    + "cliente.Apellido, cliente.Nombre, venta.fecha, venta.costoTotal,"
                    + "componenteentrada.fabricante, componenteentrada.modelo, componenteentrada.precio,"
                    + "componentesalida.fabricante, componentesalida.modelo, componentesalida.precio,"
                    + "componenteuc.fabricante, componenteuc.modelo, componenteuc.precio"
                    + "FROM cliente INNER JOIN venta ON venta.Cliente_idCliente = cliente.idCliente"
                    + "INNER JOIN ordenador ON ordenador.idOrdenador = venta.ordenador_idOrdenador"
                    + "INNER JOIN componenteuc ON componenteuc.idComponenteUC = ordenador.componenteuc_idComponenteUC"
                    + "INNER JOIN perifericoentrada ON perifericoentrada.Ordenador_idOrdenador = ordenador.idOrdenador"
                    + "INNER JOIN componenteentrada ON componenteentrada.idComponenteEntrada = perifericoentrada.ComponenteEntrada_idComponenteEntrada"
                    + "INNER JOIN perifericosalida ON perifericosalida.Ordenador_idOrdenador = ordenador.idOrdenador"
                    + "INNER JOIN componentesalida ON componentesalida.idComponenteSalida = perifericosalida.ComponenteSalida_idComponenteSalida"
                    + "WHERE cliente.nombre = \"" + clienteNombre + "\";");
            return resultSet;
        } catch (SQLException e) {
            System.out.println("Error crear la sentencia " + e.getMessage());
        }
        return null;
    }
    
}
