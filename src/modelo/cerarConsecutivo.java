/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Controlador.conectarBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julian Navarro
 */
public class cerarConsecutivo {
String radicado="";
    public cerarConsecutivo() {
        try {
            String consultaSemestre = "SELECT * FROM `semestre` WHERE 1";
            Connection miConnecion = new conectarBd().getMiConeccion();
            PreparedStatement sql = miConnecion.prepareStatement(consultaSemestre);
            ResultSet tabla = sql.executeQuery();
            String semestre="";
            if(tabla.next()){
                semestre= tabla.getString(1);
            }
            String consultaMaxConsecutivo = "SELECT max(consecutivo)as final FROM idradicado";
            PreparedStatement sql1 = miConnecion.prepareStatement(consultaMaxConsecutivo);
            ResultSet tabla1 = sql1.executeQuery();
            int consecutivo=0;
            if(tabla1.next()){
                consecutivo=tabla1.getInt(1);
            }
            
            String insertConsecutivo = "INSERT INTO `idradicado`(`consecutivo`, `Semestre`) VALUES (?,?)";
            PreparedStatement sql2 = miConnecion.prepareStatement(insertConsecutivo);
            sql2.setString(2, semestre);
            sql2.setInt(1, consecutivo+1);
            sql2.execute();
            radicado=(consecutivo+1)+"-"+semestre;
        } catch (SQLException ex) {
            Logger.getLogger(cerarConsecutivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getRadicado() {
        return radicado;
    }

}
