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
public class buscarRadicadosXusuario {

    long cedula;
    ArrayList<ArrayList> valores = new ArrayList<>();

    public buscarRadicadosXusuario(long cedula) {
        this.cedula = cedula;
        consultar();
    }

    private void consultar() {
        try {
            String consulta = "SELECT usuarioatendido.radicado,usuarioatendido.fecha,usuarioatendido.area,radicado.nombreEstudiante,usuarioatendido.Asunto,radicado.Activo,radicado.EstadoActual FROM radicado RIGHT JOIN usuarioatendido on radicado.radicado=usuarioatendido.radicado WHERE usuarioatendido.cedula= ?";
            Connection miCoeccion = new conectarBd().getMiConeccion();
            PreparedStatement sql = miCoeccion.prepareStatement(consulta);
            sql.setLong(1, cedula);
            ResultSet table = sql.executeQuery();
            while (table.next()) {
                ArrayList<String> v = new ArrayList<>();
                for (int i = 0; i < 7; i++) {
                    String valor = table.getString(i + 1);
                    if (valor==null){
                       valor= "Sin asignar"; 
                    }
                    v.add(valor);
                    
                }
                valores.add(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(buscarRadicadosXusuario.class.getName()).log(Level.SEVERE, null, ex);
            Icon error = new ImageIcon(getClass().getResource("/folder/dok.png"));
            JOptionPane.showMessageDialog(null, "No se encontro el usuario", "ERROR", WIDTH, error);
        }
    }

    public ArrayList<ArrayList> getValores() {
        return valores;
    }

}
