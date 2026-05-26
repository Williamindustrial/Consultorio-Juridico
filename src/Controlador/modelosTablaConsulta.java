/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.consultarEdades;
import modelo.consultarEstadisticaAsuntos;

/**
 *
 * @author Asus
 */
public class modelosTablaConsulta {

    String fecha1, fecha2, asunto, area, consulta;
    int[] datosAbajo;
    ArrayList<String> cabecera;

    public modelosTablaConsulta(String fecha1, String fecha2, String asunto, String area, String consulta, ArrayList<String> cabecera) {
        this.fecha1 = fecha1;
        this.fecha2 = fecha2;
        this.asunto = asunto;
        this.area = area;
        this.consulta = consulta;
        this.cabecera = cabecera;
    }

    public DefaultTableModel Tabla() throws SQLException {
        modelo.consultarEstadisticaAsuntos c = new consultarEstadisticaAsuntos(fecha1, fecha2, asunto, area, consulta);
        ArrayList<ArrayList> datos = c.getMatrix();
        DefaultTableModel tabla;
        tabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return columna == 5;
            }

        };

        //cabecera.add("Total");
        datosAbajo = new int[cabecera.size()];
        for (int i = 0; i < cabecera.size(); i++) {
            tabla.addColumn(cabecera.get(i));

        }
        tabla.setRowCount(1);
        tabla.addColumn("Total");
        int total = 0;
        for (int i = 0; i < datos.size(); i++) {
            int numero = Integer.parseInt(datos.get(i).get(1).toString());
            for (int j = 0; j < cabecera.size(); j++) {
                if (datos.get(i).get(0) != null) {
                    if (datos.get(i).get(0).equals(cabecera.get(j))) {
                        datosAbajo[j] = numero;
                        tabla.setValueAt(numero, 0, j);
                        total = total + numero;
                    }
                }
            }
        }
        //datosAbajo[cabecera.size()]=total;
        tabla.setValueAt(total, 0, cabecera.size());

        return tabla;
    }
    
    public DefaultTableModel TablaEdades() throws SQLException {
        modelo.consultarEdades c= new consultarEdades(fecha1, fecha2, asunto, area);
        ArrayList<ArrayList> datos = c.getMatrix();
        DefaultTableModel tabla;
        tabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return columna == 5;
            }

        };

        //cabecera.add("Total");
        datosAbajo = new int[cabecera.size()];
        for (int i = 0; i < cabecera.size(); i++) {
            tabla.addColumn(cabecera.get(i));

        }
        tabla.setRowCount(1);
        tabla.addColumn("Total");
        int total = 0;
        for (int i = 0; i < datos.size(); i++) {
            int numero = Integer.parseInt(datos.get(i).get(1).toString());
            for (int j = 0; j < cabecera.size(); j++) {
                if (datos.get(i).get(0) != null) {
                    if (datos.get(i).get(0).equals(cabecera.get(j))) {
                        datosAbajo[j] = numero;
                        tabla.setValueAt(numero, 0, j);
                        total = total + numero;
                    }
                }
            }
        }
        //datosAbajo[cabecera.size()]=total;
        tabla.setValueAt(total, 0, cabecera.size());

        return tabla;
    }

    public int[] getDatosAbajo() {
        return datosAbajo;
    }

    public ArrayList<String> getCabecera() {
        return cabecera;
    }

}
