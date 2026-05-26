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
import modelo.crearRadicado;
import modelo.eventos;

/**
 *
 * @author William Torres
 */
public class CrearRadicado {

    private javax.swing.JComboBox<String> area;
    private javax.swing.JTextField asunto;
    private javax.swing.JTextField cedula;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JTextField radicado;
    private javax.swing.JTextField usuario;
    boolean cerrar= true;

    public CrearRadicado(JComboBox<String> area, JTextField asunto, JTextField cedula, JDateChooser fecha, JTextField radicado, JTextField usuario) {
        this.area = area;
        this.asunto = asunto;
        this.cedula = cedula;
        this.fecha = fecha;
        this.radicado = radicado;
        this.usuario = usuario;
        crear();
    }

    private void crear() {
        try {
        String Area = area.getSelectedItem().toString();
        String Asunto = asunto.getText();
        System.out.println(cedula.getText());
        long Cedula = Long.valueOf(cedula.getText()).longValue();
        String day = fecha.getDateFormatString();
        JTextField fechaI = (JTextField) (fecha.getDateEditor().getUiComponent());
        String Fecha = fechaI.getText();
        String Radicado= radicado.getText();
        String Usuario = usuario.getText();
        crearRadicado r= new crearRadicado(Fecha, Radicado, Usuario, Area, Asunto, Cedula);
        modelo.eventos e = new eventos(Radicado, Fecha, "Radicación", "Radicado");
       } catch( Exception e){
            Icon error = new ImageIcon(getClass().getResource("/folder/dok.png"));
            JOptionPane.showMessageDialog(null, "Verifique los campos", "ERROR", WIDTH, error);
            cerrar= false;
        }
    }

    public boolean isCerrar() {
        return cerrar;
    }

}
