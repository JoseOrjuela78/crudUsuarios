/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Controlador.controlador;
import Vista.formulario;

/**
 *
 * @author alfre
 */
public class Principal {
    
    public static formulario frm_ru;
    public static Controlador.controlador c_frm_ru;
    
    
    public static void main(String[] args){
        
        frm_ru = new formulario();
        frm_ru.setVisible(true);
        frm_ru.setLocationRelativeTo(null);
        c_frm_ru = new controlador(frm_ru);
        c_frm_ru.mostrarTabla(frm_ru.tablaUsuarios);
    }
    
      
    
}
