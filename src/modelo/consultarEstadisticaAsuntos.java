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
public class consultarEstadisticaAsuntos {
    ArrayList<ArrayList> matrix= new ArrayList<>();
    public consultarEstadisticaAsuntos(String fecha1, String fecha2, String asunto,String area, String consulta) throws SQLException {
        //String consulta="SELECT usuarioatendido.Asunto,fichabibliografica.PersonaConDiscapacidad, COUNT(fichabibliografica.PersonaConDiscapacidad)as totalAño FROM fichabibliografica LEFT JOIN usuarioatendido on fichabibliografica.radicadoInterno= usuarioatendido.radicado WHERE usuarioatendido.fecha BETWEEN ? AND ? AND usuarioatendido.Asunto= ? AND usuarioatendido.area=? GROUP BY fichabibliografica.PersonaConDiscapacidad";
        Connection miConnecion = new conectarBd().getMiConeccion();
        PreparedStatement sql= miConnecion.prepareStatement(consulta);
        sql.setString(1, fecha1);
        sql.setString(2, fecha2);
        sql.setString(3, asunto);
        sql.setString(4, area);
        ResultSet tabla= sql.executeQuery();
        while(tabla.next()){
            ArrayList<String> Datos= new ArrayList<>();
            Datos.add(tabla.getString(2));
            Datos.add(tabla.getString(3));
            matrix.add(Datos);
        }
    }

    public ArrayList<ArrayList> getMatrix() {
        return matrix;
    }
    
}
