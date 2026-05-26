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
public class compleentoRadicado {
    String juez,radicadoInterno,radicadoExterno,nombreUsuario,Asunto,nombreEstudiante,fechaRadicacion;
    long CedulaUsuario,cedulaEstudiante;
    boolean activo=true;

    public compleentoRadicado(String juez, String radicadoInterno, String radicadoExterno, String nombreUsuario, String Asunto, String nombreEstudiante, String fechaRadicacion, long CedulaUsuario, long cedulaEstudiante) {
        this.juez = juez;
        this.radicadoInterno = radicadoInterno;
        this.radicadoExterno = radicadoExterno;
        this.nombreUsuario = nombreUsuario;
        this.Asunto = Asunto;
        this.nombreEstudiante = nombreEstudiante;
        this.fechaRadicacion = fechaRadicacion;
        this.CedulaUsuario = CedulaUsuario;
        this.cedulaEstudiante = cedulaEstudiante;
        consulta();
    }

    
    
    private void consulta(){
        try {
            String consulta= "INSERT INTO radicado (radicado,radicadoExterno,Juez,CedulaUsuario,nombreUsuario,cedulaEstudiante,nombreEstudiante,Asunto,Activo, fechaRadicacion,EstadoActual) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            Connection miConnecion= new conectarBd().getMiConeccion();
            PreparedStatement sql = miConnecion.prepareStatement(consulta);
            sql.setString(1, radicadoInterno);
            sql.setString(2, radicadoExterno);
            sql.setString(3, juez);
            sql.setLong(4, CedulaUsuario);
            sql.setString(5, nombreUsuario);
            sql.setLong(6, cedulaEstudiante);
            sql.setString(7, nombreEstudiante);
            sql.setString(8, Asunto);
            sql.setBoolean(9, activo);
            sql.setString(10, fechaRadicacion);
            sql.setString(11, "Radicado");
            sql.execute();
            Icon i = new ImageIcon(getClass().getResource("/folder/bien.png"));
            JOptionPane.showMessageDialog(null, "Se ha asignado el caso correctamente", "", WIDTH, i);
        
        } catch (SQLException ex) {
            Icon error = new ImageIcon(getClass().getResource("/folder/dok.png"));
            JOptionPane.showMessageDialog(null, "No se encontro el usuario", "ERROR", WIDTH, error);
            ex.printStackTrace();
        }
        
    }
    
}