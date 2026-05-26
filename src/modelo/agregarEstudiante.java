/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Controlador.conectarBd;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Julian Navarro
 */
public class agregarEstudiante {
    String nombres,apellidos,codigoUniversidad,correo;
    long cedula,telefono,celular;

    public agregarEstudiante(String nombres, String apellidos, String correo, String codigoUniversidad, long cedula, long telefono, long celular) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.codigoUniversidad = codigoUniversidad;
        this.cedula = cedula;
        this.telefono = telefono;
        this.celular = celular;
        Agregar();
    }
    private void Agregar(){
        
        try {
            Connection miconeccion= new conectarBd().getMiConeccion();
            String consulta="INSERT INTO estudiante(Nombres,Apellidos,Cedula,codigouniversidad,Telefono,celular,correo,estado) VALUES(?,?,?,?,?,?,?,?)";
            java.sql.PreparedStatement upUser = miconeccion.prepareStatement(consulta);
            upUser.setString(1, nombres);
            upUser.setString(2, apellidos);
            upUser.setLong(3, cedula);
            upUser.setString(4, codigoUniversidad);
            upUser.setLong(5, telefono);  
            upUser.setLong(6, celular);
            upUser.setString(7, correo);
            upUser.setBoolean(8, true);
            upUser.execute();
             Icon i = new ImageIcon(getClass().getResource("/folder/bien.png"));
            JOptionPane.showMessageDialog(null, "Se agrego el estudiante correctamente", "", WIDTH, i);
        } catch (SQLException ex) {
            Logger.getLogger(agregarEstudiante.class.getName()).log(Level.SEVERE, null, ex);
            Icon error = new ImageIcon(getClass().getResource("/folder/dok.png"));
            JOptionPane.showMessageDialog(null, "No se encontro el usuario", "ERROR", WIDTH, error);
        }
    }
    
    
    
}
