/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplication.servlet.dao;

import com.aplication.servlet.conexion.JDBCDataAccessClass;
import com.aplication.servlet.entidades.ConsultaHorasExtras;
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
public class ConsultaHorasExtrasDAO {

    private static Connection _connection = JDBCDataAccessClass.getInstance();

    /**
     * consulta cuantas horas extras y en que filiales hizo un trabajador en un
     * determinado mes y anio
     *
     * @param mes
     * @param anio
     * @param dni
     * @return
     */
    public static List<ConsultaHorasExtras> consultaHorasExtras(String mes, String anio, String dni) {

        List<ConsultaHorasExtras> lsConsultaHorasExtras = new ArrayList<>();

        Statement statement = null;
        try {
            statement = _connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select "
                    + "dni_trabajador"
                    + ",nombres_trabajador"
                    + ",apellido_paterno_trabajador"
                    + ",apellido_materno_trabajador"
                    + ",id_filial"
                    + ",nombre_filial"
                    + ",mes_horas_extras"
                    + ",anio_horas_extras"
                    + ",fecha_horas_extras"
                    + ",numero_horas_extras"
                    + ",pago_por_hora"
                    + ",pago_total_hora_extras"
                    + " from con_horas_extras"
                    + " where mes_horas_extras = " + mes
                    + " and anio_horas_extras = " + anio
                    + " and dni_trabajador = '" + dni + "'");

            while (resultSet.next()) {

                ConsultaHorasExtras consultaHorasExtras = new ConsultaHorasExtras();
                consultaHorasExtras.setDniTrabajador(resultSet.getString("dni_trabajador"));
                consultaHorasExtras.setNombresTrabajador(resultSet.getString("nombres_trabajador"));
                consultaHorasExtras.setApellidoPaternoTrabajador(resultSet.getString("apellido_paterno_trabajador"));
                consultaHorasExtras.setApellidoMaternoTrabajador(resultSet.getString("apellido_materno_trabajador"));
                consultaHorasExtras.setIdFilial(resultSet.getInt("id_filial"));
                consultaHorasExtras.setNombreFilial(resultSet.getString("nombre_filial"));
                consultaHorasExtras.setMesHorasExtras(resultSet.getInt("mes_horas_extras"));
                consultaHorasExtras.setAnioHorasExtras(resultSet.getInt("anio_horas_extras"));
                consultaHorasExtras.setFechaHorasExtras(resultSet.getDate("fecha_horas_extras"));
                consultaHorasExtras.setNumeroHorasExtras(resultSet.getInt("numero_horas_extras"));
                consultaHorasExtras.setPagoPorHora(resultSet.getDouble("pago_por_hora"));
                consultaHorasExtras.setPagoTotalHoraExtras(resultSet.getDouble("pago_total_hora_extras"));

                lsConsultaHorasExtras.add(consultaHorasExtras);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error crear la sentencia "
                    + e.getMessage());
        }
        return lsConsultaHorasExtras;

    }

    public static List<ConsultaHorasExtras> consultaHorasExtras(String anio, String dni) {

        List<ConsultaHorasExtras> lsConsultaHorasExtras = new ArrayList<>();

        Statement statement = null;
        try {
            statement = _connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select "
                    + "dni_trabajador"
                    + ",nombres_trabajador"
                    + ",apellido_paterno_trabajador"
                    + ",apellido_materno_trabajador"
                    + ",id_filial"
                    + ",nombre_filial"
                    + ",mes_horas_extras"
                    + ",anio_horas_extras"
                    + ",fecha_horas_extras"
                    + ",numero_horas_extras"
                    + ",pago_por_hora"
                    + ",pago_total_hora_extras"
                    + " from con_horas_extras"
                    + " where anio_horas_extras = " + anio
                    + " and dni_trabajador = '" + dni + "'");

            while (resultSet.next()) {

                ConsultaHorasExtras consultaHorasExtras = new ConsultaHorasExtras();
                consultaHorasExtras.setDniTrabajador(resultSet.getString("dni_trabajador"));
                consultaHorasExtras.setNombresTrabajador(resultSet.getString("nombres_trabajador"));
                consultaHorasExtras.setApellidoPaternoTrabajador(resultSet.getString("apellido_paterno_trabajador"));
                consultaHorasExtras.setApellidoMaternoTrabajador(resultSet.getString("apellido_materno_trabajador"));
                consultaHorasExtras.setIdFilial(resultSet.getInt("id_filial"));
                consultaHorasExtras.setNombreFilial(resultSet.getString("nombre_filial"));
                consultaHorasExtras.setMesHorasExtras(resultSet.getInt("mes_horas_extras"));
                consultaHorasExtras.setAnioHorasExtras(resultSet.getInt("anio_horas_extras"));
                consultaHorasExtras.setFechaHorasExtras(resultSet.getDate("fecha_horas_extras"));
                consultaHorasExtras.setNumeroHorasExtras(resultSet.getInt("numero_horas_extras"));
                consultaHorasExtras.setPagoPorHora(resultSet.getDouble("pago_por_hora"));
                consultaHorasExtras.setPagoTotalHoraExtras(resultSet.getDouble("pago_total_hora_extras"));

                lsConsultaHorasExtras.add(consultaHorasExtras);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error crear la sentencia "
                    + e.getMessage());
        }
        return lsConsultaHorasExtras;

    }

    public static void main(String[] args) {

        System.out.println(" CONSULTA HORA EXTRA POR ANIO, MES");
        consultaHorasExtras("2018", "11111111").forEach(System.out::println);

//        System.out.println("==HORAS EXTRAS DEL DNI = 11111111 MES = 1 ANIO =2018 =============");
//        consultaHorasExtras("1","2018", "11111111").forEach(System.out::println);
//        System.out.println("==HORAS EXTRAS DEL DNI = 11111111 MES = 2 ANIO =2018 =============");
//        consultaHorasExtras("2","2018", "11111111").forEach(System.out::println);
//        System.out.println("==HORAS EXTRAS DEL DNI = 11111111 MES = 3 ANIO =2018 =============");
//        consultaHorasExtras("3","2018", "11111111").forEach(System.out::println);
//        System.out.println("==HORAS EXTRAS DEL DNI = 11111111 MES = 4 ANIO =2018 =============");
//        consultaHorasExtras("4","2018", "11111111").forEach(System.out::println);
//        System.out.println("==HORAS EXTRAS DEL DNI = 55555555 MES = 1 ANIO =2018 =============");
//        consultaHorasExtras("1","2018", "55555555").forEach(System.out::println);
    }
}
