/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import vista.AuxiliarIp;

/**
 *
 * @author William
 */
public class conectarBd {
 static Statement miStatement;
 static Connection miConeccion;
    public void conectarBD(String Ip, String puerto, String NombreBD, String usuario, String contraseña) {
        try {
          //  String direccion = "jdbc:mysql://" + Ip + ":" + puerto + "/" + NombreBD;
          String direccion = "jdbc:mysql://" + Ip  + "/" + NombreBD;
            miConeccion = DriverManager.getConnection(direccion, usuario, contraseña);
            mostrarLogin show = new mostrarLogin();
            show.showLogin();
            
        } catch (SQLException ex) {
            /*AuxiliarIp a = new AuxiliarIp();
            a.setVisible(true);*/
            JOptionPane.showMessageDialog(null, "No se pudo conectar al servidor", "Error", 0);
        }

    }

    public Statement getMiStatement() {
        return miStatement;
    }

    public Connection getMiConeccion() {
        return miConeccion;
    }
    

}
