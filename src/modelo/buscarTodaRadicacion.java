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
public class buscarTodaRadicacion {

    String radicado;
    ArrayList<String> valores = new ArrayList<>();
    boolean activo = true;

    public buscarTodaRadicacion(String radicado) {
        this.radicado = radicado;
        buscar();
    }

    private void buscar() {
        try {
            String consulta = "SELECT * FROM radicado WHERE radicado.radicado=?";
            Connection miConecion = new conectarBd().getMiConeccion();
            PreparedStatement sql = miConecion.prepareStatement(consulta);
            sql.setString(1, radicado);
            ResultSet tabla = sql.executeQuery();
            while (tabla.next()) {
                for (int i = 0; i < 11; i++) {
                    if (i == 9) {
                        activo = tabla.getBoolean(i + 1);
                    } else {
                        valores.add(tabla.getString(i + 1));
                    }
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(buscarTodaRadicacion.class.getName()).log(Level.SEVERE, null, ex);
            Icon error = new ImageIcon(getClass().getResource("/folder/dok.png"));
            JOptionPane.showMessageDialog(null, "No se encontro el usuario", "ERROR", WIDTH, error);
        }

    }

    public ArrayList<String> getValores() {
        return valores;
    }

    public boolean isActivo() {
        return activo;
    }

}
