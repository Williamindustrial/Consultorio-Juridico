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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Julian Navarro
 */
public class consultarEstudiantesActivos {
String nombres,apellidos,cedula,codigo,celular;
    ArrayList<ArrayList> matrix= new ArrayList<>();
    public consultarEstudiantesActivos() {
        try {
            Connection miConneccion = new conectarBd().getMiConeccion();
            String consulta = "SELECT Nombres,Apellidos,Cedula,codigoUniversidad,celular FROM estudiante WHERE estado=1";
            PreparedStatement sql = miConneccion.prepareStatement(consulta);
            ResultSet miTabla = sql.executeQuery();
            while (miTabla.next()) {
               nombres=miTabla.getString("Nombres");
               apellidos=miTabla.getString("Apellidos");
               cedula=Long.toString(miTabla.getLong("Cedula"));
               codigo=miTabla.getString("codigoUniversidad");
               celular=Long.toString(miTabla.getLong("celular"));
               ArrayList<String> a= new ArrayList<>();
               a.add(nombres);
               a.add(apellidos);
               a.add(cedula);
               a.add(codigo);
               matrix.add(a);
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(consultarEstudiantesActivos.class.getName()).log(Level.SEVERE, null, ex);
            Icon error = new ImageIcon(getClass().getResource("/folder/dok.png"));
            JOptionPane.showMessageDialog(null, "No se encontro el usuario", "ERROR", WIDTH, error);
        }

    }

    public ArrayList<ArrayList> getMatrix() {
        return matrix;
    }

    
    
}
