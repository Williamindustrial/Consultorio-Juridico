/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Controlador.conectarBd;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class ActualizarEstado {

    String consulta = "UPDATE radicado SET Activo=?,EstadoActual=? WHERE radicado.radicado=?";
    String radicado;

    public ActualizarEstado(String radicado, boolean activo, String estado) {
        try {
            Connection miConecion = new conectarBd().getMiConeccion();
            PreparedStatement sql = miConecion.prepareStatement(consulta);
            sql.setBoolean(1, activo);
            sql.setString(2, estado);
            sql.setString(3, radicado);
            sql.execute();
            Icon i = new ImageIcon(getClass().getResource("/folder/bien.png"));
            if(activo){
              JOptionPane.showMessageDialog(null, "Se actualizo correctamente", "", WIDTH, i);  
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ActualizarEstado.class.getName()).log(Level.SEVERE, null, ex);
            Icon error = new ImageIcon(getClass().getResource("/folder/dok.png"));
            JOptionPane.showMessageDialog(null, "No se encontro el usuario", "ERROR", WIDTH, error);
        }

    }

}
