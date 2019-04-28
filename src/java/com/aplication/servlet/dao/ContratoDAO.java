/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplication.servlet.dao;

import com.aplication.servlet.conexion.JDBCDataAccessClass;
import static com.aplication.servlet.dao.TrabajadorDAO.consultaTodosTrabajadores;
import static com.aplication.servlet.dao.TrabajadorDAO.registrarTrabajador;
import com.aplication.servlet.entidades.Contrato;
import com.aplication.servlet.entidades.Trabajador;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author usuario
 */
public class ContratoDAO {

    private static Connection _connection = JDBCDataAccessClass.getInstance();

    //no es necesario ingresar codigo de contrato, este se genera automaticamente
    public static boolean registrarContrato(Contrato contrato) {

        Statement statement = null;
        try {
            statement = _connection.createStatement();

            String query = "insert into contrato ("
                    //+ "id_contrato"
                    + "filial_id"
                    + ",trabajador_id"
                    + ",pago_por_hora"
                    + ",nro_horas_mensual"
                    + ",fecha_inicio"
                    + ",fecha_final"
                    + ",cargo_trabajador_id) "
                    + "values ("
                    //+ contrato.getIdContrato()
                    + "" + contrato.getFilialId()
                    + "," + contrato.getTrabajadorId()
                    + "," + contrato.getPagoPorHora()
                    + "," + contrato.getNumeroHorasMensual()
                    + ",'" + contrato.getFechaInicio() + "'"
                    + ",'" + contrato.getFechaFinal() + "'"
                    + "," + contrato.getCargoTrabajadorId() + ")";
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

    public static Contrato obtenerContrato(Integer id) {

        Statement statement = null;
        try {
            statement = _connection.createStatement();

            String query = "select "
                    + "id_contrato"
                    + ",filial_id"
                    + ",trabajador_id"
                    + ",pago_por_hora"
                    + ",nro_horas_mensual"
                    + ",fecha_inicio"
                    + ",fecha_final"
                    + ",cargo_trabajador_id "
                    + "from contrato "
                    + "where id_contrato = " + id;
            System.out.println("Ejecutando=" + query);
            ResultSet rs = statement.executeQuery(query);

            rs.next();
            Contrato contrato = new Contrato();
            contrato.setIdContrato(rs.getInt("id_contrato"));
            contrato.setFilialId(rs.getInt("filial_id"));
            contrato.setTrabajadorId(rs.getInt("trabajador_id"));
            contrato.setPagoPorHora(rs.getDouble("pago_por_hora"));
            contrato.setNumeroHorasMensual(rs.getInt("nro_horas_mensual"));
            contrato.setFechaInicio(rs.getString("fecha_inicio"));
            contrato.setFechaFinal(rs.getString("fecha_final"));
            contrato.setCargoTrabajadorId(rs.getInt("cargo_trabajador_id"));

            return contrato;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error crear la sentencia "
                    + e.getMessage());
            return null;
        }
    }

    public static void ejecutar(String query) {

        Statement statement = null;
        try {
            statement = _connection.createStatement();

            System.out.println("Ejecutando=" + query);
            ResultSet r = statement.executeQuery(query);

            while (r.next()) {

                System.out.print(r.getInt(5) + "-");
                System.out.print(r.getString(6) + "-");
                System.out.println(r.getString(7));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error crear la sentencia "
                    + e.getMessage());
        }

    }

    public static void main(String[] args) {

//        System.out.println(obtenerContrato(1));

        Contrato contrato = new Contrato();
        contrato.setFilialId(1);
        contrato.setTrabajadorId(1);
        contrato.setPagoPorHora(2.0);
        contrato.setNumeroHorasMensual(200);
        contrato.setFechaInicio("2018-01-01");
        contrato.setFechaFinal("2018-01-01");
        contrato.setCargoTrabajadorId(1);
        registrarContrato(contrato);

    }

}
