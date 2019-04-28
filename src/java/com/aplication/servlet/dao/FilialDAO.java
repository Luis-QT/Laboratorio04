/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplication.servlet.dao;

import com.aplication.servlet.conexion.JDBCDataAccessClass;
import com.aplication.servlet.entidades.Filial;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class FilialDAO {

    private static Connection _connection = JDBCDataAccessClass.getInstance();

    public static List<Filial> consultaTodasFiliales() {

        List<Filial> lsFiliales = new ArrayList<>();

        Statement statement = null;
        try {
            statement = _connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select "
                    + "id_filial"
                    + ",tipo_filial_id"
                    + ",nombre"
                    + ",direccion"
                    + " from filial");

            while (resultSet.next()) {

                Filial filial = new Filial();
                filial.setIdFilial(resultSet.getInt("id_filial"));
                switch (resultSet.getInt("tipo_filial_id")) {
                    case 1:
                        filial.setTipoFilial("Fabricación");
                        break;
                    case 2:
                        filial.setTipoFilial("Distribución");
                        break;
                    case 3:
                        filial.setTipoFilial("Venta");
                        break;
                }
                filial.setNombre(resultSet.getString("nombre"));
                filial.setDireccion(resultSet.getString("direccion"));

                lsFiliales.add(filial);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error crear la sentencia "
                    + e.getMessage());
        }
        return lsFiliales;

    }

    //el id de trabajador se genera automaticamente
    public static boolean registrarFilial(Filial filial) {

        Statement statement = null;
        try {
            statement = _connection.createStatement();

            Integer tipoFilial = null;
            switch (filial.getTipoFilial()) {
                case "Fabricación":
                    tipoFilial = 1;
                    break;
                case "Distribución":
                    tipoFilial = 2;
                    break;
                case "Venta":
                    tipoFilial = 3;
                    break;
            }
            String query = "insert into filial ("
                    + "tipo_filial_id"
                    + ",nombre"
                    + ",direccion) "
                    + "values ("
                    + tipoFilial
                    + ",'" + filial.getNombre() + "'"
                    + ",'" + filial.getDireccion() + "')";

            System.out.println("Ejecutando=" + query);
            statement.execute(query);

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error crear la sentencia "
                    + e.getMessage());
            return false;
        }

    }

    //el id de trabajador se genera automaticamente
    public static boolean actualizarFilial(Filial filial) {

        Statement statement = null;
        try {
            statement = _connection.createStatement();

            Integer tipoFilial = null;
            switch (filial.getTipoFilial()) {
                case "Fabricación":
                    tipoFilial = 1;
                    break;
                case "Distribución":
                    tipoFilial = 2;
                    break;
                case "Venta":
                    tipoFilial = 3;
                    break;
            }

            String query = "update filial SET "
                    + "tipo_filial_id=" + tipoFilial
                    + ",nombre='" + filial.getNombre() + "'"
                    + ",direccion=" + "'" + filial.getDireccion() + "'"
                    + " where "
                    + "id_filial=" + filial.getIdFilial();

            System.out.println("Ejecutando=" + query);
            statement.execute(query);

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error crear la sentencia "
                    + e.getMessage());
            return false;
        }

    }

    public static boolean eliminarFilial(Integer id) {
        Statement statement = null;
        try {
            statement = _connection.createStatement();

            String query = "delete from filial where id_filial = " + id;

            System.out.println("Ejecutando=" + query);
            statement.execute(query);

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error crear la sentencia "
                    + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("===== lista de trabajadores =============");
        consultaTodasFiliales().forEach(System.out::println);
        
        
//
//        System.out.println("====INSERTANDO TRABAJADOR");
//        Trabajador trabajador = new Trabajador();
//        trabajador.setDni("12345678");
//        trabajador.setNombres("Nuevo Trabajador2");
//        trabajador.setApellidoPaterno("ApellidoP2");
//        trabajador.setApellidoMaterno("ApellidoM2");
//        trabajador.setTelefono("212300002");
//        trabajador.setDireccion("Direccion2");
//        registrarTrabajador(trabajador);
//
//        Trabajador trabajador2 = new Trabajador();
//        trabajador2.setIdTrabajador(6);
//        trabajador2.setDni("12345678");
//        trabajador2.setNombres("Modificado");
//        trabajador2.setApellidoPaterno("Modificado");
//        trabajador2.setApellidoMaterno("Modificado");
//        trabajador2.setTelefono("00000000");
//        trabajador2.setDireccion("Modificado");
//        actualizarTrabajador(trabajador2);
//        System.out.println(eliminarTrabajador(7));
    }
}
