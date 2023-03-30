/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author alfre
 */
public class ConexionDB {
    private static final String URL = "jdbc:mysql://localhost:3307/users";
    private static final String user = "root";
    private static final String passaword = "";
 
    public static Connection getConexion() throws SQLException{
        return DriverManager.getConnection(URL, user, passaword);
    }
    
    public static void cerrar(Connection conexion )throws SQLException{
    conexion.close();
    }
    
     public static void cerrar(Statement sentencia )throws SQLException{
    sentencia.close();
     
    }
     
     public static void cerrar(PreparedStatement sentencia )throws SQLException{
    sentencia.close();
    
    }
     
    public static void cerrar(ResultSet resultado )throws SQLException{
    resultado.close();
    
    }
}

