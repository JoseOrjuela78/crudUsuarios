/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author alfre
 */
public class Usuario {
    private int idusuarios;
    private String nombres;
    private String apellidos ;
    private int edad;
    private String email;
    private String estado;
    
    public Usuario (){
    }
    
    // opcion para eliminar
    public Usuario(int idusuarios) {
        this.idusuarios = idusuarios;
    }
      // opcion para crear
       public Usuario(String nombres, String apellidos, int edad, String email, String estado) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.email = email;
        this.estado = estado;
    }
// opcion para actualizar
    public Usuario(int idusuarios, String nombres, String apellidos, int edad, String email, String estado) {
        this.idusuarios = idusuarios;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.email = email;
        this.estado = estado;
    }

    // metodos getter y setter
    public int getIdusuarios() {
        return idusuarios;
    }

    public void setIdusuarios(int idusuarios) {
        this.idusuarios = idusuarios;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    // opcion para devolver contenido usuario

    @Override
    public String toString() {
        return "Usuario{" + "idusuarios=" + idusuarios + ", nombres=" + nombres + ", apellidos=" + apellidos + ", edad=" + edad + ", email=" + email + ", estado=" + estado + '}';
    }

    
}
