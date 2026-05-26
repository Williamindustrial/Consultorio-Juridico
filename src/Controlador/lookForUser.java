/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.buscarUsuario;

/**
 *
 * @author William
 */
public class lookForUser {

    javax.swing.JLabel Estado;
    javax.swing.JLabel apellidos;
    javax.swing.JLabel correo;
    javax.swing.JLabel fechaIngreso;
    javax.swing.JTextField cedula;
    javax.swing.JLabel nombres;

    public lookForUser(JLabel Estado, JLabel apellidos, JLabel correo, JLabel fechaIngreso, JTextField cedula, JLabel nombres) {
        this.Estado = Estado;
        this.apellidos = apellidos;
        this.correo = correo;
        this.fechaIngreso = fechaIngreso;
        this.cedula = cedula;
        this.nombres = nombres;
    }

    public void buscar() throws SQLException {
        try{
        Connection miconeccion = conectarBd.miConeccion;
        int numCedula = Integer.parseInt(cedula.getText());
        buscarUsuario bus = new buscarUsuario(numCedula, miconeccion);
        bus.buscar();
        if (bus.isEntro()) {
            Estado.setText(bus.getEstado());
            apellidos.setText(bus.getApellido());
            correo.setText(bus.getCorreo());
            fechaIngreso.setText(bus.getFecha());
            nombres.setText(bus.getNombres());
            Icon i = new ImageIcon(getClass().getResource("/folder/bien.png"));
            JOptionPane.showMessageDialog(null, "Usuario agregado al sistema", "", WIDTH, i);
        } else {
            Icon error = new ImageIcon(getClass().getResource("/folder/dok.png"));
            JOptionPane.showMessageDialog(null, "No se encontro el usuario", "ERROR", WIDTH, error);
        }
        } catch(Exception e){
            Icon error = new ImageIcon(getClass().getResource("/folder/dok.png"));
            JOptionPane.showMessageDialog(null, "No se encontro el usuario", "ERROR", WIDTH, error);
        }
    }

}
