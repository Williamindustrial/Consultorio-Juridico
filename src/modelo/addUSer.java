/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author William
 */
public class addUSer {
    String tipoUsuario,nombres,apellidos,correo;
    int cedula;
    String fechaIngreso;
    Connection miConeccion;

    public addUSer(String tipoUsuario, String nombres, String apellidos, String correo, int cedula, String fechaIngreso, Connection miConeccion) {
        this.tipoUsuario = tipoUsuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.cedula = cedula;
        this.fechaIngreso = fechaIngreso;
        this.miConeccion = miConeccion;
    }
    
    public void agregar() throws SQLException{
        String consulta= "INSERT INTO usuario (TIPODEUSUARIO, CEDULA,NOMBRES, APELLIDOS, CODIGOUNIVERSIDAD,FECHADEINGRESO,ESTADO,CONTRASEÑA) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement upUser = miConeccion.prepareStatement(consulta);
        upUser.setString(1, tipoUsuario);
        upUser.setInt(2, cedula);
        upUser.setString(3, nombres);
        upUser.setString(4, apellidos);
        upUser.setString(5, correo);
        upUser.setString(6, fechaIngreso);
        upUser.setString(7, "ACTIVO");
        upUser.setString(8, cedula+"");
        upUser.execute();
        String mensajee= "USUARIO : "+  nombres+" " +apellidos+ "\n"+ "CONTRASEÑA: "+  cedula;
            String asunto= "Bienvenido al consultorio juridico";
            String destino= correo;
            enviarCorrreo e = new enviarCorrreo(destino, asunto, mensajee);
            e.enviarMail();
    }
    
    
}
