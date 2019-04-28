/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplication.servlet.dao;

import com.aplication.servlet.conexion.JDBCDataAccessClass;
import com.aplication.servlet.entidades.HoraExtra;
import com.aplication.servlet.entidades.Trabajador;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

/**
 *
 * @author usuario
 */
public class HoraExtraDAO {

    private static Connection _connection = JDBCDataAccessClass.getInstance();

    //el id de trabajador se genera automaticamente
    public static boolean registrarHoraExtra(HoraExtra horaExtra) {

        Statement statement = null;
        try {
            statement = _connection.createStatement();

            String query = "insert into horas_extras ("
                    //+ "id_horas_extras"
                    + "contrato_id"
                    + ",filial_id"
                    + ",numero_horas"
                    + ",fecha) "
                    + "values ("
                    //horaExtra.getIdHoraExtra()
                    + horaExtra.getContratoId()
                    + "," + horaExtra.getFilialId()
                    + "," + horaExtra.getNumeroHoras()
                    + ",'" + horaExtra.getFecha() + "')";
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
        HoraExtra he = new HoraExtra();
        he.setContratoId(4);
        he.setNumeroHoras(2);
        he.setFilialId(2);
        he.setFecha("2019-01-01");
        registrarHoraExtra(he);
    }

}
