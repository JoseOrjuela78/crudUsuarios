/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Usuario;
import Modelo.UsuarioDAO;
import Vista.formulario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alfre
 */
public class controlador implements ActionListener{
    
    formulario frm_ru;
// importacion los botones y se asigna un evento click
    public controlador(formulario frm_ru) {
        this.frm_ru = frm_ru;
        this.frm_ru.btnGuardar.addActionListener(this);
        this.frm_ru.btnActualizar.addActionListener(this);
        this.frm_ru.btnBorrar.addActionListener(this);
       }
// identificacion de un evento en cada click
    @Override
    public void actionPerformed(ActionEvent e) {
      // asignacion de metodo a botones de la vista
        if(e.getSource()== frm_ru.btnGuardar){
       
       String nombres = frm_ru.txtNombres.getText();
       String apellidos = frm_ru.txtApellidos.getText();
       String email = frm_ru.txtEmail.getText();
       int edad = Integer.parseInt(frm_ru.txtEdad.getText());
       String estado = frm_ru.txtEstado.getText();
       
       Usuario user = new Usuario(nombres,apellidos,edad, email,estado);
       registrarUsuario(user);
       mostrarTabla(frm_ru.tablaUsuarios);    
       limpiarEntradas();
       
       }
      
       if(e.getSource()== frm_ru.btnActualizar){
           
       int idusuarios = Integer.parseInt(frm_ru.txtIdusuario.getText());    
       String nombres = frm_ru.txtNombres.getText();
       String apellidos = frm_ru.txtApellidos.getText();
       String email = frm_ru.txtEmail.getText();
       int edad = Integer.parseInt(frm_ru.txtEdad.getText());
       String estado = frm_ru.txtEstado.getText();
       
       Usuario user = new Usuario(idusuarios,nombres,apellidos,edad, email,estado);
       actualizarUsuario(user);
       mostrarTabla(frm_ru.tablaUsuarios);    
       limpiarEntradas();
           
       }
       
       if(e.getSource()== frm_ru.btnBorrar){
           int idusuarios = Integer.parseInt(frm_ru.txtIdusuario.getText());
           Usuario user = new Usuario(idusuarios);
           borrarUsuario(user);
           mostrarTabla(frm_ru.tablaUsuarios);    
           limpiarEntradas();
       }

    }
// metodo para limpiar campos
    private void limpiarEntradas() {
    
         frm_ru.txtNombres.setText("");
         frm_ru.txtApellidos.setText("");
         frm_ru.txtEmail.setText("");
         frm_ru.txtEdad.setText("");
         frm_ru.txtEstado.setText("");
         
    }
 // metodo para mostrar tabla   
    public void mostrarTabla(JTable tabla){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("idusuarios");
        modelo.addColumn("nombres");
        modelo.addColumn("apellidos");
        modelo.addColumn("email");
        modelo.addColumn("edad");
        modelo.addColumn("estado");
        UsuarioDAO usuarioDao = new UsuarioDAO();
        try{
        List<Usuario> usuarios = usuarioDao.mostrar();
         for(Usuario rs: usuarios){
         Object [] list ={rs.getIdusuarios(),rs.getNombres(),rs.getApellidos(),rs.getEmail(),rs.getEdad(),rs.getEstado()};
         modelo.addRow(list);
         }
         
         tabla.setModel(modelo);
        }catch(Exception e){
            
            System.out.println("error al listar datos" + e.getMessage());
        }
    }
   // metodo para regsitar usuario 
    public void registrarUsuario(Usuario usuario){
        UsuarioDAO usuarioDao = new UsuarioDAO();
    try{
        int rows = 0;
       rows = usuarioDao.insertar(usuario);
    }catch(Exception e){
            
            System.out.println("error al insertar datos" + e.getMessage());
        }
    
    
    }
  // metodo para actualizar usuario  
        public void actualizarUsuario(Usuario usuario){
        UsuarioDAO usuarioDao = new UsuarioDAO();
    try{
        int rows = 0;
       rows = usuarioDao.actualizar(usuario);
    }catch(Exception e){
            
            System.out.println("error al insertar datos" + e.getMessage());
        }
    
    
    }
  // metodo para borrar usuario  
   public void borrarUsuario(Usuario usuario){
        UsuarioDAO usuarioDao = new UsuarioDAO();
    try{
        int rows = 0;
       rows = usuarioDao.eliminar(usuario);
    }catch(Exception e){
            
            System.out.println("error al insertar datos" + e.getMessage());
        }
    
    
    }
    
}
