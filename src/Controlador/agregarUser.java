/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.toedter.calendar.JDateChooser;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.addUSer;

/**
 *
 * @author William
 */
public class agregarUser {

    JTextField apellidos;
    JTextField cedula;
    JTextField correo;
    JDateChooser fecha_Ingreso;
    JTextField nombres;
    JComboBox<String> tipo_usuario;

    public agregarUser(JTextField apellidos, JTextField cedula, JTextField correo, JDateChooser fecha_Ingreso, JTextField nombres, JComboBox<String> tipo_usuario) throws SQLException {
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.correo = correo;
        this.fecha_Ingreso = fecha_Ingreso;
        this.nombres = nombres;
        this.tipo_usuario = tipo_usuario;
        leerFrame();
    }

    public void leerFrame() throws SQLException {
        try {
            String tipoUsuario, Nombres, Apellidos, Correo, fechaIngreso;
            int Cedula;
            Connection miConeccion = new conectarBd().getMiConeccion();
            tipoUsuario = (String) tipo_usuario.getSelectedItem();
            Nombres = nombres.getText();
            Apellidos = apellidos.getText();
            Correo = correo.getText();
            Cedula = Integer.parseInt(cedula.getText());
            String day = fecha_Ingreso.getDateFormatString();
            JTextField fechaI = (JTextField) (fecha_Ingreso.getDateEditor().getUiComponent());
            fechaIngreso = fechaI.getText();
            addUSer agr = new addUSer(tipoUsuario, Nombres, Apellidos, Correo, Cedula, fechaIngreso, miConeccion);
            agr.agregar();
        } catch (Exception e) {
            Icon error = new ImageIcon(getClass().getResource("/folder/dok.png"));
            JOptionPane.showMessageDialog(null, "Verifique los campos", "ERROR", WIDTH, error);
        }
    }

}
