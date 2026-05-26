/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static java.awt.image.ImageObserver.WIDTH;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.leerIp;
import vista.AuxiliarIp;

/**
 *
 * @author William
 */
public class writeIp {

    private JTextField JTip, jPuerto, JUsuarioBd, JnombreBd, Jcontraseña;
    String rol;

    public writeIp(JTextField JTip, JTextField jPuerto, JTextField JUsuarioBd, JTextField JnombreBd, JTextField Jcontraseña, String rol) {
        this.JTip = JTip;
        this.jPuerto = jPuerto;
        this.JUsuarioBd = JUsuarioBd;
        this.JnombreBd = JnombreBd;
        this.Jcontraseña = Jcontraseña;
        this.rol = rol;
    }

    

    public void write() {
        String file = "";
        file = "C:\\Program Files (x86)\\SCJ\\ip_Server";
        while (true) {
            try {
                String OSArch = System.getProperty("os.arch").toLowerCase();
                FileWriter ipConf = null;
                ipConf = new FileWriter(file);
                BufferedWriter escritor = new BufferedWriter(ipConf);
                String ip = JTip.getText();
                escritor.write(ip);
                escritor.newLine();
                String puerto = jPuerto.getText();
                escritor.write(puerto);
                escritor.newLine();
                String usuario = JUsuarioBd.getText();
                escritor.write(usuario);
                escritor.newLine();
                String nombreBD = JnombreBd.getText();
                escritor.write(nombreBD);
                escritor.newLine();
                String pass = Jcontraseña.getText();
                escritor.write(pass);
                escritor.newLine();
                escritor.write(rol);
                escritor.close();
                System.out.println(OSArch);
                break;
            } catch (IOException ex) {
                Logger.getLogger(AuxiliarIp.class.getName()).log(Level.SEVERE, null, ex);
                file = "C:\\Program Files\\SCJ\\ip_Server";
                continue;
            }
        }
        conectarBd b = new conectarBd();

        leerIp read = new leerIp();
        try {
            read.readIp(file);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex, "no se pudo leer el archivo", WIDTH);
        }
  //      b.conectarBD(read.getIp(), read.getPuerto(), read.getNombreBD(), read.getUsuario(), read.getContraseña());
    }

}
