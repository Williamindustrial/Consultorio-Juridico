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

/**
 *
 * @author Asus
 */
public class consultarAsuntosXArea {
    ArrayList<ArrayList> matrix= new ArrayList<>();
    public consultarAsuntosXArea(String area) throws SQLException {
        String consulta="SELECT usuarioatendido.Asunto, COUNT(usuarioatendido.Asunto) FROM usuarioatendido WHERE usuarioatendido.area=? GROUP BY usuarioatendido.Asunto";
        Connection miConnecion= new conectarBd().getMiConeccion();
        PreparedStatement sql= miConnecion.prepareStatement(consulta);
        sql.setString(1, area);
        ResultSet tabla= sql.executeQuery();
        while(tabla.next()){
            ArrayList<String> datos= new ArrayList();
            datos.add(tabla.getString(1));
            datos.add(tabla.getString(2));
            matrix.add(datos);
        }
    }

    public ArrayList<ArrayList> getMatrix() {
        return matrix;
    }
    
}
