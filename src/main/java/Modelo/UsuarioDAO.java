/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alfre
 */
public class UsuarioDAO {
    
    public static final String SQL_SELECT = "SELECT * FROM usuarios";
    public static final String SQL_INSERT = "INSERT INTO usuarios (nombres,apellidos,email,edad,estado) VALUES (?,?,?,?,?)";
    public static final String SQL_UPDATE = "UPDATE usuarios SET nombres = ?,apellidos = ?,email = ?, edad = ?, estado = ? WHERE idusuarios = ?";
    public static final String SQL_DELETE = "DELETE FROM usuarios WHERE idusuarios = ?";

    // metodo para obtener todos los usuarios
    public List<Usuario> mostrar(){
        Connection conexion = null;
        PreparedStatement sentencia = null;
        ResultSet resultado = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();
    
        try{
            conexion = ConexionDB.getConexion();
            sentencia = conexion.prepareStatement(SQL_SELECT);
            resultado = sentencia.executeQuery();
            
            while(resultado.next()){
                usuario = new Usuario();
                usuario.setIdusuarios(resultado.getInt("idusuarios"));
                usuario.setNombres(resultado.getString("nombres"));
                usuario.setApellidos(resultado.getString("apellidos"));
                usuario.setEmail(resultado.getString("email"));
                usuario.setEdad(resultado.getInt("edad"));
                usuario.setEstado(resultado.getString("estado"));
                usuarios.add(usuario);
            }
        }catch(SQLException e){ 
        e.printStackTrace(System.out);
        }finally{
            try{
                ConexionDB.cerrar(resultado);
                ConexionDB.cerrar(sentencia);
                ConexionDB.cerrar(conexion);
            }catch(SQLException e){ 
        e.printStackTrace(System.out);
            }
        }
        
        return usuarios;
    }
    // metodo para crear un usuario
    public int insertar(Usuario usuario){
        Connection conexion = null;
        PreparedStatement sentencia = null;
        int registros = 0;
        
        try{
           
           conexion = ConexionDB.getConexion();
           sentencia = conexion.prepareStatement(SQL_INSERT);
           sentencia.setString(1, usuario.getNombres());
           sentencia.setString(2, usuario.getApellidos());
           sentencia.setString(3,usuario.getEmail());
           sentencia.setInt(4, usuario.getEdad());
           sentencia.setString(5,usuario.getEstado());
           registros = sentencia.executeUpdate();
            
        }catch(SQLException e){ 
        e.printStackTrace(System.out);
        }finally{
            try{
                ConexionDB.cerrar(sentencia);
                ConexionDB.cerrar(conexion);
            }catch(SQLException e){ 
        e.printStackTrace(System.out);
            }
        }
        
        return registros;
        
    }
    // metodo para actualizar un usuario
    public int actualizar(Usuario usuario){
        Connection conexion = null;
        PreparedStatement sentencia = null;
        int registros = 0;
        
        try{
           
           conexion = ConexionDB.getConexion();
           sentencia = conexion.prepareStatement(SQL_UPDATE);
           sentencia.setString(1, usuario.getNombres());
           sentencia.setString(2, usuario.getApellidos());
           sentencia.setString(3,usuario.getEmail());
           sentencia.setInt(4, usuario.getEdad());
           sentencia.setString(5,usuario.getEstado());
           sentencia.setInt(6, usuario.getIdusuarios());
           registros = sentencia.executeUpdate();
                       
        }catch(SQLException e){ 
        e.printStackTrace(System.out);
        }finally{
            try{
                ConexionDB.cerrar(sentencia);
                ConexionDB.cerrar(conexion);
            }catch(SQLException e){ 
        e.printStackTrace(System.out);
            }
        }
        
        return registros;
        
    }
     // metodo para eliminar un usuario
     public int eliminar(Usuario usuario){
        Connection conexion = null;
        PreparedStatement sentencia = null;
        int registros = 0;
        
        try{
           
           conexion = ConexionDB.getConexion();
           sentencia = conexion.prepareStatement(SQL_DELETE);
           sentencia.setInt(1,usuario.getIdusuarios());
           registros = sentencia.executeUpdate();
            
        }catch(SQLException e){ 
        e.printStackTrace(System.out);
        }finally{
            try{
                ConexionDB.cerrar(sentencia);
                ConexionDB.cerrar(conexion);
            }catch(SQLException e){ 
        e.printStackTrace(System.out);
            }
        }
        
        return registros;
        
    }
}
