/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author William
 */
public class deleteUser {

    Connection miconeccion;
    int cedula;

    public deleteUser(Connection miconeccion, int cedula) {
        this.miconeccion = miconeccion;
        this.cedula = cedula;
    }

    public void eliminar() throws SQLException {
        try {
            String eliminacion = "DELETE FROM usuario WHERE CEDULA=?";
            PreparedStatement eliminar = miconeccion.prepareStatement(eliminacion);
            eliminar.setInt(1, cedula);
            eliminar.execute();
        } catch (Exception e) {
            Icon error = new ImageIcon(getClass().getResource("/folder/dok.png"));
            JOptionPane.showMessageDialog(null, "Verifique los campos", "ERROR", WIDTH, error);
        }
    }

}
