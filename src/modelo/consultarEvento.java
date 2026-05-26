/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Controlador.conectarBd;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class consultarEvento {

    String radicacion;
    ArrayList<ArrayList> datos = new ArrayList<>();

    public consultarEvento(String radicacion) {
        this.radicacion = radicacion;
        consultar();
    }

    private void consultar() {
        try {
            String consulta = "SELECT fecha,evento,detalles FROM eventos WHERE radicado=? ORDER BY fecha ASC";
            java.sql.Connection miConeccion = new conectarBd().getMiConeccion();
            PreparedStatement sql = miConeccion.prepareStatement(consulta);
            sql.setString(1, radicacion);
            ResultSet miTabla = sql.executeQuery();
            while (miTabla.next()) {
                ArrayList<String> d = new ArrayList<>();
                for (int i = 1; i <= 3; i++) {
                    d.add(miTabla.getString(i));
                }
                datos.add(d);
            }

        } catch (SQLException ex) {
            Logger.getLogger(consultarEvento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<ArrayList> getDatos() {
        return datos;
    }
    

}
