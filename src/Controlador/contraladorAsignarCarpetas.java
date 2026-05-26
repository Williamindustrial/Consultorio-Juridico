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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import modelo.compleentoRadicado;

/**
 *
 * @author Julian Navarro
 */
public class contraladorAsignarCarpetas {

    javax.swing.JTextField juez;
    javax.swing.JTextField nombreJuducante;
    javax.swing.JTextField radicado;
    javax.swing.JTextField radicadoExterno;
    javax.swing.JTextField usuario;
    javax.swing.JTextField asunto;
    javax.swing.JTextField cedulaJudicante;
    javax.swing.JTextField cedulaUsuario;
    com.toedter.calendar.JDateChooser fecha;

    public contraladorAsignarCarpetas(JTextField juez, JTextField nombreJuducante, JTextField radicado, JTextField radicadoExterno, JTextField usuario, JTextField asunto, JTextField cedulaJudicante, JTextField cedulaUsuario, JDateChooser fecha) {
        this.juez = juez;
        this.nombreJuducante = nombreJuducante;
        this.radicado = radicado;
        this.radicadoExterno = radicadoExterno;
        this.usuario = usuario;
        this.asunto = asunto;
        this.cedulaJudicante = cedulaJudicante;
        this.cedulaUsuario = cedulaUsuario;
        this.fecha = fecha;
        controlador();
    }

    

    private void controlador() {
        try {
            String Juez = juez.getText();
            String nombreDelJudicante = nombreJuducante.getText();
            String Radicado = this.radicado.getText();
            String RadicadExterno = radicadoExterno.getText();
            String Usuario = usuario.getText();
            String Asunto = asunto.getText();
            long CedulaJudicante = Long.valueOf(cedulaJudicante.getText());
            long CedulaUsuario = Long.valueOf(cedulaUsuario.getText());
            JTextField fechaI = (JTextField) (fecha.getDateEditor().getUiComponent());
            String Fecha = fechaI.getText();
            modelo.compleentoRadicado r = new compleentoRadicado(Juez, Radicado, RadicadExterno, Usuario, Asunto, nombreDelJudicante, Fecha, CedulaUsuario, CedulaJudicante);
            System.out.println("agrefo");
        } catch (Exception e) {
            Icon error = new ImageIcon(getClass().getResource("/folder/dok.png"));
            JOptionPane.showMessageDialog(null, "Verifique los campos", "ERROR", WIDTH, error);
        }

    }
}
