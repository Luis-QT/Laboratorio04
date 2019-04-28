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

    private java.sql.Connection _connection;
    public Statement statement;
    private String serverName = "localhost";
    private String portNumber = "3306"; //33065
    private String databaseName = "laboratorio04?zeroDateTimeBehavior=convertToNull";
    private String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + databaseName;
    private String userName = "root";
    private String password = "";
    
    public void initialize() {
        try {
            DriverManager.registerDriver(new Driver());
            _connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            System.out.println("Error al registrar el controlador " + e.getMessage());
        }
    }
    
    public Connection getInstance(){
        if (_connection == null){
            initialize();
        }
        return _connection;
    }

    public void disconnect() throws SQLException{
        _connection.close();
    }

}
