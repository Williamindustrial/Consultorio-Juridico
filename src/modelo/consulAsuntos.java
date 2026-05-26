/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Controlador.conectarBd;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author Asus
 */
public class consulAsuntos {
    LinkedList<String> asunto = new LinkedList<>();
    public consulAsuntos(String area, String ley) throws SQLException {
        String consulta= "SELECT Asunto FROM asuntos  WHERE Area= ?  and Ley=? ORDER BY Asunto ASC" ;
        Connection miConeccion = new conectarBd().getMiConeccion();
        PreparedStatement sql = (PreparedStatement) miConeccion.prepareStatement(consulta);
        sql.setString(1, area);
        sql.setString(2, ley);
        ResultSet tabla = sql.executeQuery();
        while(tabla.next()){
            asunto.add(tabla.getString(1));
        }
    }

    public LinkedList<String> getAsunto() {
        return asunto;
    }
    
}
