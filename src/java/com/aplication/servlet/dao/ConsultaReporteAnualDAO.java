/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplication.servlet.dao;

import com.aplication.servlet.conexion.JDBCDataAccessClass;
import com.aplication.servlet.entidades.ConsultaContrato;
import com.aplication.servlet.entidades.ConsultaReporteAnual;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usuario
 */
public class ConsultaReporteAnualDAO {

    private static Connection _connection = JDBCDataAccessClass.getInstance();

    /**
     * Consulta el reporte anual de un trabajador, segun el anio
     *
     * @param anio
     * @param dni
     * @return
     */
    public static List<ConsultaReporteAnual> consultaReporteAnual(String anio, String dni) {

        List<ConsultaReporteAnual> lsConsultaReporteAnual = new ArrayList<>();

        Statement statement = null;
        try {
            statement = _connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select dni_trabajador"
                    + ", nombres_trabajador"
                    + ", apellido_paterno_trabajador"
                    + ", apellido_materno_trabajador"
                    + ", id_filial"
                    + ", nombre_filial"
                    + ", mes_pagado"
                    + ", anio_pagado"
                    + ", numero_horas_mes_pagado"
                    + ", pago_por_horas_mes_pagado"
                    + ", id_contrato"
                    + ", total_hora_extras"
                    + ", sueldo_mensual"
                    + ", pago_horas_extras"
                    + ", pago_total"
                    + " from con_reporte_anual where anio_pagado = " + anio + " and dni_trabajador = '" + dni + "'");

            while (resultSet.next()) {
                ConsultaReporteAnual reporteAnual = new ConsultaReporteAnual();
                reporteAnual.setDniTrabajador(resultSet.getString("dni_trabajador"));
                reporteAnual.setNombresTrabajador(resultSet.getString("nombres_trabajador"));
                reporteAnual.setApellidoPaternoTrabajador(resultSet.getString("apellido_paterno_trabajador"));
                reporteAnual.setApellidoMaternoTrabajador(resultSet.getString("apellido_materno_trabajador"));
                reporteAnual.setIdFilial(resultSet.getInt("id_filial"));
                reporteAnual.setNombreFilial(resultSet.getString("nombre_filial"));
                reporteAnual.setMesPagado(resultSet.getInt("mes_pagado"));
                reporteAnual.setAnioPagado(resultSet.getInt("anio_pagado"));
                reporteAnual.setNumeroHorasMesPagado(resultSet.getInt("numero_horas_mes_pagado"));
                reporteAnual.setPagoPorHorasMesPagado(resultSet.getDouble("pago_por_horas_mes_pagado"));
                reporteAnual.setIdContrato(resultSet.getInt("id_contrato"));
                reporteAnual.setTotalHoraExtras(resultSet.getInt("total_hora_extras"));
                reporteAnual.setSueldoMensual(resultSet.getDouble("sueldo_mensual"));
                reporteAnual.setPagoHorasExtras(resultSet.getDouble("pago_horas_extras"));
                reporteAnual.setPagoTotal(reporteAnual.getSueldoMensual() + reporteAnual.getPagoHorasExtras());

                lsConsultaReporteAnual.add(reporteAnual);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error crear la sentencia "
                    + e.getMessage());
        }
        return lsConsultaReporteAnual;

    }

    public static List<ConsultaContrato> consultaReporteAnual2(String anio, String dni) {
        List<ConsultaContrato> lsConsultaReporteAnual = new ArrayList<>();

        Statement statement = null;
        try {
            statement = _connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select "
                    + "id_contrato"
                    + " ,dni_trabajador"
                    + " ,nombre_filial"
                    + " ,nombres_trabajador"
                    + ", id_filial"
                    + ", numero_horas_mes_pagado"
                    + " ,pago_por_horas_mes_pagado"
                    + " ,sueldo_mensual"
                    + ", fecha_inicio"
                    + ", fecha_fin"
                    + " from con_contratos where dni_trabajador = '" + dni + "'"
            );

            while (resultSet.next()) {
                ConsultaContrato reporteAnual = new ConsultaContrato();
                reporteAnual.setIdContrato(resultSet.getInt("id_contrato"));
                reporteAnual.setDniTrabajador(resultSet.getString("dni_trabajador"));
                reporteAnual.setNombreFilial(resultSet.getString("nombre_filial"));
                reporteAnual.setNombresTrabajador(resultSet.getString("nombres_trabajador"));
                reporteAnual.setIdFilial(resultSet.getInt("id_filial"));
                reporteAnual.setNumeroHorasMesPagado(resultSet.getInt("numero_horas_mes_pagado"));
                reporteAnual.setPagoPorHorasMesPagado(resultSet.getDouble("pago_por_horas_mes_pagado"));
                reporteAnual.setSueldoMensual(resultSet.getDouble("sueldo_mensual"));
                reporteAnual.setFechaInicio(resultSet.getDate("fecha_inicio"));
                reporteAnual.setFechaFin(resultSet.getDate("fecha_fin"));

                lsConsultaReporteAnual.add(reporteAnual);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error crear la sentencia "
                    + e.getMessage());
        }
        return lsConsultaReporteAnual;
    }

    public static void main(String[] args) {
//        System.out.println("Trabajador del año 2018 con dni 11111111");
        List<ConsultaContrato> lsConsultaReporteAnual = consultaReporteAnual2("2018", "11111111");
        lsConsultaReporteAnual.forEach(System.out::println);

        List<ConsultaReporteAnual> lsFinal = new ArrayList<>();

        lsConsultaReporteAnual.forEach(e -> {
            Date i = e.getFechaInicio();
            Date f = e.getFechaFin();

            while (i.getTime() < f.getTime()) {
                System.out.println(i);
                i.setTime((long)i.getTime()+(86400000*30));
            }

        });

//        System.out.println("Trabajador del año 2018 con dni 55555555");
//        consultaReporteAnual("2018", "55555555").forEach(System.out::println);
    }
}

class ConsutaTotalHorasMensuales {

    private String dniTrabajador;
    private Integer mesHorasExtras;
    private Integer anioHorasExtras;
    private Integer numeroHorasExtras;
    private Double pagoTotalHorasExtras;

    public String getDniTrabajador() {
        return dniTrabajador;
    }

    public void setDniTrabajador(String dniTrabajador) {
        this.dniTrabajador = dniTrabajador;
    }

    public Integer getMesHorasExtras() {
        return mesHorasExtras;
    }

    public void setMesHorasExtras(Integer mesHorasExtras) {
        this.mesHorasExtras = mesHorasExtras;
    }

    public Integer getAnioHorasExtras() {
        return anioHorasExtras;
    }

    public void setAnioHorasExtras(Integer anioHorasExtras) {
        this.anioHorasExtras = anioHorasExtras;
    }

    public Integer getNumeroHorasExtras() {
        return numeroHorasExtras;
    }

    public void setNumeroHorasExtras(Integer numeroHorasExtras) {
        this.numeroHorasExtras = numeroHorasExtras;
    }

    public Double getPagoTotalHorasExtras() {
        return pagoTotalHorasExtras;
    }

    public void setPagoTotalHorasExtras(Double pagoTotalHorasExtras) {
        this.pagoTotalHorasExtras = pagoTotalHorasExtras;
    }

    @Override
    public String toString() {
        return "ConsutaTotalHorasMensuales{" + "dniTrabajador=" + dniTrabajador + ", mesHorasExtras=" + mesHorasExtras + ", anioHorasExtras=" + anioHorasExtras + ", numeroHorasExtras=" + numeroHorasExtras + ", pagoTotalHorasExtras=" + pagoTotalHorasExtras + '}';
    }

}
