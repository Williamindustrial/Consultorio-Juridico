/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static modelo.consultarLogin.cedula;

/**
 *
 * @author William
 */
public class cambiarClave {

    String claveActual, nuevaClave, confirmacion;
    Connection miConeccion;
    private boolean cambiocontraseña = false;

    public cambiarClave(String claveActual, String nuevaClave, String confirmacion, Connection miConeccion) {
        this.claveActual = claveActual;
        this.nuevaClave = nuevaClave;
        this.confirmacion = confirmacion;
        this.miConeccion = miConeccion;
    }

    public void cambiarPass() throws SQLException {

        String actualizacion = "UPDATE usuario  SET CONTRASEÑA=? WHERE CEDULA=? and CONTRASEÑA=?";
        PreparedStatement actualizarContraseña = miConeccion.prepareStatement(actualizacion);
        actualizarContraseña.setString(1, nuevaClave);
        actualizarContraseña.setInt(2, consultarLogin.cedula);
        actualizarContraseña.setString(3, claveActual);
        actualizarContraseña.execute();
        String consultar = "SELECT CONTRASEÑA FROM usuario WHERE CEDULA=? AND CONTRASEÑA=?";
        PreparedStatement consulta = miConeccion.prepareStatement(consultar);
        consulta.setInt(1,consultarLogin.cedula );
        consulta.setString(2, nuevaClave);
        ResultSet miTabla = consulta.executeQuery();
        while (miTabla.next()) {
            
            if (nuevaClave.equals(miTabla.getString("CONTRASEÑA"))) {
                cambiocontraseña = true;
            }
        }

    }

    public boolean isCambiocontraseña() {
        return cambiocontraseña;
    }
    

}
