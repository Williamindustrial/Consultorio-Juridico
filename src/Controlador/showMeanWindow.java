/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import modelo.consultarLogin;
import vista.ventanaPrincipal;


/**
 *
 * @author William
 */
public class showMeanWindow {

    JTextField Jusuario;
    JPasswordField clave;
    private boolean contraseñaCorrecta;
    String complemento;
    public showMeanWindow(JTextField Jusuario, JPasswordField clave, String complemento) {
        this.Jusuario = Jusuario;
        this.clave = clave;
        this.complemento= complemento;
    }

    public void show() throws SQLException {
        String correo = Jusuario.getText()+complemento;
        char[] con = clave.getPassword();
        String contraseña="";
        for (int i = 0; i < con.length; i++) {
            contraseña+= con[i];;
            
        }
        
        Connection miConeccion = new conectarBd().getMiConeccion();
        consultarLogin consultar = new consultarLogin(miConeccion, correo, contraseña);
        consultar.doConsult();
        contraseñaCorrecta = consultar.isContraseñaCorrecta();
        String nombre = consultar.getNombre();
        if (contraseñaCorrecta) {
            String linea = "Bienvenido " + nombre;
            Icon i = new ImageIcon(getClass().getResource("/folder/bien.png"));
            JOptionPane.showMessageDialog(null, linea, "Bienvenido", WIDTH, i);
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }

            /*try{
            UIManager.setLookAndFeel(new SyntheticaStandardLookAndFeel());
            }
            catch (Exception e){
            
            }*/
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new ventanaPrincipal().setVisible(true);
                }
            });
            
        } else {
            Icon error = new ImageIcon(getClass().getResource("/folder/error.png"));
            JOptionPane.showMessageDialog(null, "Verifique usuario y contraseña", "No se encontro el usuario", WIDTH, error);
        }

    }

    public boolean isContraseñaCorrecta() {
        return contraseñaCorrecta;
    }
    
    
}
