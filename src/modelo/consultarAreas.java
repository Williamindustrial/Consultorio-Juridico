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
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class consultarAreas {

    LinkedList<String> areas = new LinkedList<>();

    public consultarAreas() {
        try {
            String consulta = "SELECT Area FROM asuntos GROUP BY Area ORDER BY Area ASC";
            Connection miConeccion = new conectarBd().getMiConeccion();
            PreparedStatement sql = miConeccion.prepareStatement(consulta);
            ResultSet tabla = sql.executeQuery();
            while (tabla.next()) {
                String dato = tabla.getString(1);
                areas.add(dato);
            }

        } catch (SQLException ex) {
            Logger.getLogger(consultarAreas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public LinkedList<String> getAreas() {
        return areas;
    }
    
    

}
