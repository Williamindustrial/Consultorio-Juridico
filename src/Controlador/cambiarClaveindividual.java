/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import modelo.cambiarClave;
import modelo.consultarLogin;

/**
 *
 * @author William
 */
public class cambiarClaveindividual {

    private javax.swing.JPasswordField actual;
    private javax.swing.JPasswordField confirmacion;
    private javax.swing.JPasswordField nueva;
    boolean cambio = false;

    public cambiarClaveindividual(JPasswordField actual, JPasswordField confirmacion, JPasswordField nueva) {
        this.actual = actual;
        this.confirmacion = confirmacion;
        this.nueva = nueva;
    }

    public void cambiarPass() throws SQLException {

        String claveActual = "", nuevaClave = "", Confirmacion = "";
        Connection miConeccion;
        for (int i = 0; i < actual.getPassword().length; i++) {
            claveActual += actual.getPassword()[i];

        }
        for (int i = 0; i < nueva.getPassword().length; i++) {
            nuevaClave += nueva.getPassword()[i];

        }
        for (int i = 0; i < confirmacion.getPassword().length; i++) {
            Confirmacion += confirmacion.getPassword()[i];

        }

        if (Confirmacion.equals(nuevaClave)) {
            cambio = true;
            miConeccion = new conectarBd().getMiConeccion();
            cambiarClave cam = new cambiarClave(claveActual, nuevaClave, Confirmacion, miConeccion);
            cam.cambiarPass();
            if (cam.isCambiocontraseña()== false) {
                cambio = false;
                Icon error = new ImageIcon(getClass().getResource("/folder/dok.png"));
                JOptionPane.showMessageDialog(null, "Verifique la contraseña actual", "No se pudo cambiar la contraseña", WIDTH, error);
            } else {
                Icon i = new ImageIcon(getClass().getResource("/folder/ok.png"));
                JOptionPane.showMessageDialog(null, " Se ha cambiado la contraseña correctamente ", " Cambio de contraseña exitoso ", WIDTH, i);
            }
        } else {
            Icon error = new ImageIcon(getClass().getResource("/folder/dok.png"));
            JOptionPane.showMessageDialog(null, "Verifique las contraseñas ingresadas", "No se pudo cambiar la contraseña", WIDTH, error);
        }

    }

    public boolean isCambio() {
        return cambio;
    }

}
