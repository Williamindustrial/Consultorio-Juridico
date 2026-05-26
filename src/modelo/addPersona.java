/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Julian Navarro
 */
public class addPersona {
    int estrato,edad;
    long cedulaUsuario, telefono, celular;
    String nombres, apellidos, dirección,gradoEscolaridad,ocupación,fechaNacimiento,sexo, grupoEtnico, PersonaConDiscapacidad, CualDiscapacidad, victimaConflictoArmado, relacionConflictoDiscapacidad, radicado;
    Connection miConeecion;
    boolean acepto;

    public addPersona(int estrato, int edad, long cedulaUsuario, long telefono, long celular, String nombres, String apellidos, String dirección, String gradoEscolaridad, String ocupación, String fechaNacimiento, String sexo, String grupoEtnico, String PersonaConDiscapacidad, String CualDiscapacidad, String victimaConflictoArmado, String relacionConflictoDiscapacidad,boolean acepto ,String radicado,Connection miConeecion) {
        this.estrato = estrato;
        this.edad = edad;
        this.cedulaUsuario = cedulaUsuario;
        this.telefono = telefono;
        this.celular = celular;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dirección = dirección;
        this.gradoEscolaridad = gradoEscolaridad;
        this.ocupación = ocupación;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.grupoEtnico = grupoEtnico;
        this.PersonaConDiscapacidad = PersonaConDiscapacidad;
        this.CualDiscapacidad = CualDiscapacidad;
        this.victimaConflictoArmado = victimaConflictoArmado;
        this.relacionConflictoDiscapacidad = relacionConflictoDiscapacidad;
        this.acepto= acepto;
        this.radicado= radicado;
        this.miConeecion = miConeecion;
    }
  
    public void agregar() throws SQLException{
        
        String consulta= "INSERT INTO fichabibliografica(cedulaUsuario, Nombres, Apellidos, FechaNacimiento, Direccion, Estrato, Telefono, celular, GradoEscolaridad, ocupacion, edad, sexo, grupoEtnico, PersonaConDiscapacidad, CualDiscapacidad, victimaConflictoArmado, relacionConflictoDiscapacidad,Aceptar,radicadoInterno) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement upUser = miConeecion.prepareStatement(consulta);
        upUser.setLong(1, cedulaUsuario);
        upUser.setString(2,nombres);
        upUser.setString(3,apellidos);
        upUser.setString(4, fechaNacimiento);
        upUser.setString(5,dirección);
        upUser.setLong(6, estrato);
        upUser.setLong(7, telefono);
        upUser.setLong(8, celular);
        upUser.setString(9,gradoEscolaridad);
        upUser.setString(10,ocupación);
        upUser.setInt(11, edad); 
        upUser.setString(12,sexo);
        upUser.setString(13,grupoEtnico);
        upUser.setString(14,PersonaConDiscapacidad);
        upUser.setString(15,CualDiscapacidad);
        upUser.setString(16,victimaConflictoArmado);
        upUser.setString(17,relacionConflictoDiscapacidad);
        upUser.setBoolean(18, acepto);
        upUser.setString(19,radicado);
        upUser.execute();
         JOptionPane.showMessageDialog(null, "Ficha Bibliografica exitosa ", "ok", 1);
    }
    
    
    
}
