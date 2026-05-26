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
public class consultarAsuntos {
    LinkedList<String> ley= new LinkedList<>();
    public consultarAsuntos(String area) throws SQLException {
       String consulta= "SELECT Ley FROM asuntos  WHERE Area= ? GROUP BY Ley ORDER BY Asunto ASC" ;
        Connection miConeccion = new conectarBd().getMiConeccion();
        PreparedStatement sql = (PreparedStatement) miConeccion.prepareStatement(consulta);
        sql.setString(1, area);
        ResultSet tabla = sql.executeQuery();
        while(tabla.next()){
            ley.add(tabla.getString(1));
        }
       
    }

    public LinkedList<String> getLey() {
        return ley;
    }
    
}
