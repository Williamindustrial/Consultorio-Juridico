/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Controlador.conectarBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julian Navarro
 */
public class actualizarSemestre {
    String semestre;

    public actualizarSemestre(String semestre) {
        this.semestre = semestre;
        actualizar();
    }
    private void actualizar(){
        try {
            String connsulta="UPDATE `semestre` SET `semestre`=?WHERE 1";
            Connection miConeccion = new conectarBd().getMiConeccion();
            PreparedStatement sql= miConeccion.prepareStatement(connsulta);
            sql.setString(1, semestre);
            sql.execute();
        } catch (SQLException ex) {
            Logger.getLogger(actualizarSemestre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
