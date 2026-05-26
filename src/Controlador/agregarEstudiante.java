/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Julian Navarro
 */
public class agregarEstudiante {
    javax.swing.JTextField apellidos;
    javax.swing.JTextField cedula;
    javax.swing.JTextField celular;
    javax.swing.JTextField codigo;
    javax.swing.JTextField correo;
    javax.swing.JTextField nombres;
    javax.swing.JTextField telefono;

    public agregarEstudiante(JTextField apellidos, JTextField cedula, JTextField celular, JTextField codigo, JTextField correo, JTextField nombres, JTextField telefono) {
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.celular = celular;
        this.codigo = codigo;
        this.correo = correo;
        this.nombres = nombres;
        this.telefono = telefono;
        agregar();
    }
    
    private void agregar(){
        try{
        String Apellidos=apellidos.getText();
        String Nombres= nombres.getText();
        String Codigo= codigo.getText();
        String Correo= correo.getText();
        long Cedula= Long.valueOf(cedula.getText());
        long Celular=Long.valueOf(celular.getText());
        long Telefono= 0;
        if (!telefono.getText().equals("")){
            Telefono= Long.valueOf(telefono.getText());
        }
        modelo.agregarEstudiante ad= new modelo.agregarEstudiante(Nombres, Apellidos, Correo, Codigo, Cedula, Telefono, Celular);
        } catch(Exception e){
            Icon error = new ImageIcon(getClass().getResource("/folder/dok.png"));
            JOptionPane.showMessageDialog(null, "Verifique los campos", "ERROR", WIDTH, error);
        }
        
    }
}
