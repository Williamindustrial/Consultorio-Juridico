/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Controlador.conectarBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julian Navarro
 */
public class buscarEstudiante {
   long cedula;
   ArrayList<String> datos = new ArrayList<>();
    public buscarEstudiante(long cedula) {
        this.cedula = cedula;
        consultar();
    }
   private void consultar(){
       try {
           String consulta="SELECT * FROM estudiante WHERE Cedula=?";
           Connection miConeccion = new conectarBd().getMiConeccion();
           PreparedStatement sql= miConeccion.prepareStatement(consulta);
           sql.setLong(1, cedula);
           ResultSet tabla = sql.executeQuery();
           while (tabla.next()){
               ArrayList< String> d = new ArrayList<>();
               for (int i = 1 ;i <=8; i++) {
                   datos.add(tabla.getString(i));
               }
               
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(buscarEstudiante.class.getName()).log(Level.SEVERE, null, ex);
       }

       
   }

    public ArrayList<String> getDatos() {
        return datos;
    }
    
    
}
