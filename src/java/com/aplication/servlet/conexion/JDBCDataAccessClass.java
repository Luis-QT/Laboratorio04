/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplication.servlet.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import com.mysql.jdbc.Driver;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JDBCDataAccessClass {

    private static Connection _connection= null;
 

    private static void initialize() {
        try {
            DriverManager.registerDriver(new Driver());
            _connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_practica_1", "root", "");
        } catch (SQLException e) {
            System.out.println(
                    "Error al registrar el controlador"
                    + e.getMessage());
        }
    }
    
    public static Connection getInstance(){
        if (_connection == null){
            initialize();
        }
        return _connection;
    }



}
