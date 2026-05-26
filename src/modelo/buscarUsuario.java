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

/**
 *
 * @author William
 */
public class buscarUsuario {

    int cedula;
    Connection miConeccion;
    String nombres, apellido, estado, fecha, correo,contraseña;
    boolean entro= false;
    public buscarUsuario(int cedula, Connection miConeccion) {
        this.cedula = cedula;
        this.miConeccion = miConeccion;
    }

    public void buscar() throws SQLException {
        String sentencia = "SELECT * FROM usuario WHERE CEDULA=?";
        PreparedStatement buscarU = miConeccion.prepareStatement(sentencia);
        buscarU.setInt(1, cedula);
        ResultSet miTabla = buscarU.executeQuery();

        while (miTabla.next()) {
            entro=true;
            nombres = miTabla.getString("NOMBRES");
            apellido = miTabla.getString("APELLIDOS");
            estado = miTabla.getString("ESTADO");
            fecha = miTabla.getString("FECHADEINGRESO");
            correo = miTabla.getString("CODIGOUNIVERSIDAD");
            contraseña= miTabla.getString("CONTRASEÑA");
        }
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEstado() {
        return estado;
    }

    public String getFecha() {
        return fecha;
    }

    public String getCorreo() {
        return correo;
    }

    public boolean isEntro() {
        return entro;
    }

    public String getContraseña() {
        return contraseña;
    }
    

}
