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
public class agregarCerrarCaso {
    String radicado,judicante,monitor,razonCierre,fecha;
    long cedulaJudicante;

    public agregarCerrarCaso(String radicado, String judicante, String monitor, String razonCierre, long cedulaJudicante, String fecha) {
        this.radicado = radicado;
        this.judicante = judicante;
        this.monitor = monitor;
        this.razonCierre = razonCierre;
        this.cedulaJudicante = cedulaJudicante;
        this.fecha= fecha;
        cerrarCaso();
    }

    
    
    private  void  cerrarCaso(){
        try {
            String consulta="INSERT INTO librocierre (radicado,Fecha,nombreJudicante,monitor,razonCierre,cedulaJudicante) VALUES(?,?,?,?,?,?)";
            Connection miConneccion = new conectarBd().getMiConeccion();
            PreparedStatement sql = miConneccion.prepareStatement(consulta);
            sql.setString(1, radicado);
            sql.setString(2, fecha);
            sql.setString(3, judicante);
            sql.setString(4, monitor);
            sql.setString(5, razonCierre);
            sql.setLong(6, cedulaJudicante);
            sql.execute();
        } catch (SQLException ex) {
            Logger.getLogger(agregarCerrarCaso.class.getName()).log(Level.SEVERE, null, ex);
            Icon error = new ImageIcon(getClass().getResource("/folder/dok.png"));
            JOptionPane.showMessageDialog(null, "No se encontro el usuario", "ERROR", WIDTH, error);
        }
    }
    
}
