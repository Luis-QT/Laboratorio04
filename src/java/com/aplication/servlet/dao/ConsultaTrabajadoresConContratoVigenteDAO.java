/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplication.servlet.dao;

import com.aplication.servlet.conexion.JDBCDataAccessClass;
import com.aplication.servlet.entidades.ConsultaTrabajadoresConContratoVigente;
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
public class ConsultaTrabajadoresConContratoVigenteDAO {

    private static Connection _connection = JDBCDataAccessClass.getInstance();

    /**
     * esta consulta se usara para mostrar los nombres de las personas que pueden hacer horas extras 
     *
     * @param mes
     * @param anio
     * @param dni
     * @return
     */
    public static List<ConsultaTrabajadoresConContratoVigente> consultaTodosTrabajadoresConContratoVigente() {

        List<ConsultaTrabajadoresConContratoVigente> lsConsultaTrabajadoresContratoVigente = new ArrayList<>();

        Statement statement = null;
        try {
            statement = _connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select "
                    + "id_contrato"
                    + ",dni_trabajador"
                    + ",nombre_trabajador"
                    + ",apellido_paterno_trabajador"
                    + ",apellido_materno_trabajador"
                    + ",id_filial"
                    + ",nombre_filial"
                    + ",pago_por_hora"
                    + ",nro_horas_mensual"
                    + ",fecha_inicio"
                    + ",fecha_fin"
                    + " from trabajadores_con_contrato_vigente");

            while (resultSet.next()) {

                ConsultaTrabajadoresConContratoVigente trabajadorVigente = new ConsultaTrabajadoresConContratoVigente();
                trabajadorVigente.setIdContrato(resultSet.getInt("id_contrato"));
                trabajadorVigente.setDniTrabajador(resultSet.getString("dni_trabajador"));
                trabajadorVigente.setNombreTrabajador(resultSet.getString("nombre_trabajador"));
                trabajadorVigente.setApellidoPaternoTrabajador(resultSet.getString("apellido_paterno_trabajador"));
                trabajadorVigente.setApellidoMaternoTrabajador(resultSet.getString("apellido_materno_trabajador"));
                trabajadorVigente.setIdFilial(resultSet.getInt("id_filial"));
                trabajadorVigente.setNombreFilial(resultSet.getString("nombre_filial"));
                trabajadorVigente.setPagoPorHora(resultSet.getDouble("pago_por_hora"));
                trabajadorVigente.setNroHorasMensual(resultSet.getInt("nro_horas_mensual"));
                trabajadorVigente.setFechaInicio(resultSet.getDate("fecha_inicio"));
                trabajadorVigente.setFechaFin(resultSet.getDate("fecha_fin"));

                lsConsultaTrabajadoresContratoVigente.add(trabajadorVigente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error crear la sentencia "
                    + e.getMessage());
        }
        return lsConsultaTrabajadoresContratoVigente;

    }

    public static void main(String[] args) {
        System.out.println("=======================");
        consultaTodosTrabajadoresConContratoVigente().forEach(System.out::println);
        
    }
}
