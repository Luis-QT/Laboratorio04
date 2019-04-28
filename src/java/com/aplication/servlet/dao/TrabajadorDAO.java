/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplication.servlet.dao;

import com.aplication.servlet.conexion.JDBCDataAccessClass;
import com.aplication.servlet.entidades.Trabajador;
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
public class TrabajadorDAO {

    private static Connection _connection = JDBCDataAccessClass.getInstance();

    public static List<Trabajador> consultaTodosTrabajadores() {

        List<Trabajador> consultaTrabajadores = new ArrayList<>();

        Statement statement = null;
        try {
            statement = _connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select "
                    + "id_trabajador"
                    + ",dni"
                    + ",nombres"
                    + ",apellido_paterno"
                    + ",apellido_materno"
                    + ",telefono"
                    + ",direccion"
                    + " from trabajador");

            while (resultSet.next()) {

                Trabajador trabajador = new Trabajador();
                trabajador.setIdTrabajador(resultSet.getInt("id_trabajador"));
                trabajador.setDni(resultSet.getString("dni"));
                trabajador.setNombres(resultSet.getString("nombres"));
                trabajador.setApellidoPaterno(resultSet.getString("apellido_paterno"));
                trabajador.setApellidoMaterno(resultSet.getString("apellido_materno"));
                trabajador.setTelefono(resultSet.getString("telefono"));
                trabajador.setDireccion(resultSet.getString("direccion"));

                consultaTrabajadores.add(trabajador);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error crear la sentencia "
                    + e.getMessage());
        }
        return consultaTrabajadores;

    }

    //el id de trabajador se genera automaticamente
    public static boolean registrarTrabajador(Trabajador trabajador) {

        Statement statement = null;
        try {
            statement = _connection.createStatement();
            //INSERT INTO `bd_practica_1`.`trabajador` (`id_trabajador`, `dni`, `nombres`, `apellido_paterno`, 
            //`apellido_materno`, `telefono`, `direccion`) VALUES ('6', '12312312', 'xxxx', 'xxxx', 'xxxx', '1123132', 'dasadsdasads');
            String query = "insert into trabajador ("
                    //+ "id_trabajador"
                    + "dni"
                    + ",nombres"
                    + ",apellido_paterno"
                    + ",apellido_materno"
                    + ",telefono"
                    + ",direccion) "
                    + "values ("
                    //+ trabajador.getIdTrabajador()
                    + "'" + trabajador.getDni()+ "'"
                    + ",'" + trabajador.getNombres() + "'"
                    + ",'" + trabajador.getApellidoPaterno() + "'"
                    + ",'" + trabajador.getApellidoMaterno() + "'"
                    + ",'" + trabajador.getTelefono() + "'"
                    + ",'" + trabajador.getDireccion() + "')";
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
    public static boolean actualizarTrabajador(Trabajador trabajador) {

        Statement statement = null;
        try {
            statement = _connection.createStatement();

            String query = "update trabajador SET "
                    + "dni=" + "'" + trabajador.getDni() + "'"
                    + ",nombres=" + "'" + trabajador.getNombres() + "'"
                    + ",apellido_paterno=" + "'" + trabajador.getApellidoPaterno() + "'"
                    + ",apellido_materno=" + "'" + trabajador.getApellidoMaterno() + "'"
                    + ",telefono=" + "'" + trabajador.getTelefono() + "'"
                    + ",direccion=" + "'" + trabajador.getDireccion() + "'"
                    + " where "
                    + "id_trabajador=" + trabajador.getIdTrabajador();

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

    public static boolean eliminarTrabajador(Integer id) {
        Statement statement = null;
        try {
            statement = _connection.createStatement();

            String query = "delete from trabajador where id_trabajador = "+id;
                  
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
        consultaTodosTrabajadores().forEach(System.out::println);

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
