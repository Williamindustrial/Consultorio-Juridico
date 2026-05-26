/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.toedter.calendar.JDateChooser;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import modelo.modeloUsuarioNoAtendido;

/**
 *
 * @author Julian Navarro
 */
public class controladorUsuarioNoAtendido {

    javax.swing.JComboBox area;
    javax.swing.JTextArea asunto;
    javax.swing.JTextField cedula;
    javax.swing.JTextField cordinador;
    com.toedter.calendar.JDateChooser fecha;
    javax.swing.JTextField responsable;
    javax.swing.JTextField usuario;

    public controladorUsuarioNoAtendido(JComboBox area, JTextArea asunto, JTextField cedula, JTextField cordinador, JDateChooser fecha,  JTextField responsable, JTextField usuario) {
        this.area = area;
        this.asunto = asunto;
        this.cedula = cedula;
        this.cordinador = cordinador;
        this.fecha = fecha;
        this.responsable = responsable;
        this.usuario = usuario;
        controlador();
    }

    private void controlador() {
        try {
        String Area = area.getSelectedItem().toString();
        String Asunto = asunto.getText();
        long Cedula = Long.valueOf(cedula.getText());
        String Cordinador =cordinador.getText();
        JTextField fechaI = (JTextField) (fecha.getDateEditor().getUiComponent());
        String Fecha = fechaI.getText();
        String Responsable = responsable.getText();
        String Usuario= usuario.getText();
        modelo.modeloUsuarioNoAtendido model = new modeloUsuarioNoAtendido(Fecha, Asunto, Usuario, Area, Responsable, Cedula, Cordinador);
        }
        catch (Exception e){
            e.printStackTrace();
            Icon error = new ImageIcon(getClass().getResource("/folder/dok.png"));
            JOptionPane.showMessageDialog(null, "Verifique los campos", "ERROR", WIDTH, error);
        }

    }
}
