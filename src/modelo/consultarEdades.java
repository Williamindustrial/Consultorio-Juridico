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
public class consultarEdades {

    ArrayList<ArrayList> matrix = new ArrayList<>();
    String fecha1, fecha2, asunto, area;

    public consultarEdades(String fecha1, String fecha2, String asunto, String area) throws SQLException {
        this.fecha1 = fecha1;
        this.fecha2 = fecha2;
        this.asunto = asunto;
        this.area = area;
        consultar(0, 26);
        consultar(27, 60);
        consultar(61, 200);
    }

    public ArrayList<ArrayList> getMatrix() {
        return matrix;
    }

    private void consultar(int edad1, int edad2) throws SQLException {
        String consulta = "SELECT usuarioatendido.Asunto,fichabibliografica.edad,COUNT(fichabibliografica.edad) FROM fichabibliografica LEFT JOIN usuarioatendido on fichabibliografica.radicadoInterno= usuarioatendido.radicado WHERE usuarioatendido.fecha BETWEEN ? AND ? AND usuarioatendido.Asunto= ? AND usuarioatendido.area=? AND fichabibliografica.edad BETWEEN ? and ?";
        Connection miConnecion = new conectarBd().getMiConeccion();
        PreparedStatement sql = miConnecion.prepareStatement(consulta);
        sql.setString(1, fecha1);
        sql.setString(2, fecha2);
        sql.setString(3, asunto);
        sql.setString(4, area);
        sql.setInt(5, edad1);
        sql.setInt(6, edad2);
        ResultSet tabla = sql.executeQuery();
        while (tabla.next()) {
            ArrayList<String> Datos = new ArrayList<>();
            if (edad1 == 61) {
                Datos.add(edad1 + "-Infinito");
            } else {
                Datos.add(edad1 + "-" + edad2);
            }
            Datos.add(tabla.getString(3));
            matrix.add(Datos);
        }
    }

}
