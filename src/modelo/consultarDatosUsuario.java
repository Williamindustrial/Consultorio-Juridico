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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Julian Navarro
 */
public class consultarDatosUsuario {
    long cedula;
    String nombres="", apellidos="",direccion="",celular= "", telefono="",estrato="",nacimiento="",escolaridad="",ocupacion="";

    public consultarDatosUsuario(long cedula) {
        this.cedula = cedula;
        consultar();
    }

    
    private void consultar(){
        try {
            String consulta ="SELECT * FROM fichabibliografica WHERE cedulaUsuario= ?";
            Connection miConecion =  new conectarBd().getMiConeccion();
            PreparedStatement sql = miConecion.prepareStatement(consulta);
            sql.setLong(1, cedula);
            ResultSet table = sql.executeQuery();
            while (table.next()){
                nombres= table.getString("Nombres");
                apellidos=table.getString("Apellidos");
                direccion=table.getString("Direccion");
                celular=table.getString("celular");
                telefono=table.getString("Telefono");
                estrato=table.getString("Estrato");
                nacimiento=table.getString("FechaNacimiento");
                escolaridad=table.getString("GradoEscolaridad");
                ocupacion=table.getString("ocupacion");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(consultarDatosUsuario.class.getName()).log(Level.SEVERE, null, ex);
            Icon error = new ImageIcon(getClass().getResource("/folder/dok.png"));
            JOptionPane.showMessageDialog(null, "No se encontro el usuario", "ERROR", WIDTH, error);
        }
        
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCelular() {
        return celular;
    }

    public long getCedula() {
        return cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEstrato() {
        return estrato;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public String getEscolaridad() {
        return escolaridad;
    }

    public String getOcupacion() {
        return ocupacion;
    }
    
}
