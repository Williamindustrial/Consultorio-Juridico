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
import java.sql.ResultSet;
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
public class buscarLibroRadicaciones {
    String numeroRadicado;
    String usuario;
    long cedula;
    String asunto;
    String estudiante;
    long cedulaJudicante;
    public buscarLibroRadicaciones(String numeroRadicado) {
        this.numeroRadicado = numeroRadicado;
        buscar();
    }
    
    private void buscar(){
        try {
            Connection miConneccion=  new conectarBd().getMiConeccion();
            String consulta="SELECT * FROM usuarioatendido WHERE radicado =?";
            PreparedStatement sql= miConneccion.prepareStatement(consulta);
            sql.setString(1,numeroRadicado);
            ResultSet miTabla= sql.executeQuery();
            while (miTabla.next()){
                usuario=miTabla.getString(3);
                cedula= miTabla.getLong(4);
                asunto= miTabla.getString(6);
                estudiante=miTabla.getString(8);
                cedulaJudicante=miTabla.getLong(7);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(buscarLibroRadicaciones.class.getName()).log(Level.SEVERE, null, ex);
            Icon error = new ImageIcon(getClass().getResource("/folder/dok.png"));
            JOptionPane.showMessageDialog(null, "No se encontro el usuario", "ERROR", WIDTH, error);
        }
    }

    public String getUsuario() {
        return usuario;
    }

    public long getCedula() {
        return cedula;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public long getCedulaJudicante() {
        return cedulaJudicante;
    }
    
    
    
    
}
