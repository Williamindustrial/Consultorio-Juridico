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
public class asignarCasos {
    String radicado, radicadoExterno,juez,nombreUsuario,nombreEstudiante,asunto;
    boolean activo=true;
    String estado= "Radicado";
    long cedulaEstudiante,CedulaUsuario;
    String consulta= "INSERT INTO radicado(radicado,radicadoExterno,Juez,CedulaUsuario,nombreUsuario,cedulaEstudiante,nombreEstudiante,Asunto,Activo,EstadoActual) VALUES (?,?,?,?,?,?,?,?,?,?) ";

    public asignarCasos(String radicado, String radicadoExterno, String juez, String nombreUsuario, String nombreEstudiante, String asunto, long cedulaEstudiante, long CedulaUsuario) {
        this.radicado = radicado;
        this.radicadoExterno = radicadoExterno;
        this.juez = juez;
        this.nombreUsuario = nombreUsuario;
        this.nombreEstudiante = nombreEstudiante;
        this.asunto = asunto;
        this.cedulaEstudiante = cedulaEstudiante;
        this.CedulaUsuario = CedulaUsuario;
    }
    
    public void guardar(){
        try {
            Connection miConnecion = new conectarBd().getMiConeccion();
            PreparedStatement sql =miConnecion.prepareStatement(consulta);
            sql.setString(1, radicado);
            sql.setString(2, radicadoExterno);
            sql.setString(3, juez);
            sql.setLong(4, CedulaUsuario);
            sql.setString(5, nombreUsuario);
            sql.setLong(6, cedulaEstudiante);
            sql.setString(7, nombreEstudiante);
            sql.setString(8, asunto);
            sql.setBoolean(9, activo);
            sql.setString(10, estado);
            sql.execute();
            Icon i = new ImageIcon(getClass().getResource("/folder/bien.png"));
            JOptionPane.showMessageDialog(null, "El caso fue asignado correctamente ", "", WIDTH, i);
        } catch (SQLException ex) {
            Logger.getLogger(asignarCasos.class.getName()).log(Level.SEVERE, null, ex);
            Icon error = new ImageIcon(getClass().getResource("/folder/dok.png"));
            JOptionPane.showMessageDialog(null, "No se encontro el usuario", "ERROR", WIDTH, error);
        }
    }
}
