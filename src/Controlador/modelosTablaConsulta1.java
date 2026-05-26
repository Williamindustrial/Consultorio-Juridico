/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.consultarAsuntosXArea;
import modelo.consultarEdades;
import modelo.consultarEdades1;
import modelo.consultarEstadisticaAsuntos;
import modelo.consultarEstadisticaAsuntos1;
import modelo.modeloReasignarCaso;

/**
 *
 * @author Asus
 */
public class modelosTablaConsulta1 {

    String fecha1, fecha2, area, consulta;
    int[] datosAbajo;
    ArrayList<String> cabecera;

    public modelosTablaConsulta1(String fecha1, String fecha2, String area, String consulta, ArrayList<String> cabecera) {
        this.fecha1 = fecha1;
        this.fecha2 = fecha2;
        this.area = area;
        this.consulta = consulta;
        this.cabecera = cabecera;
    }

    public DefaultTableModel Tabla() throws SQLException {
        modelo.consultarEstadisticaAsuntos1 c = new consultarEstadisticaAsuntos1(fecha1, fecha2, area, consulta);
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
        modelo.consultarEdades1 c = new consultarEdades1(fecha1, fecha2, area);
        ArrayList<ArrayList> datos = c.getMatrix();
        DefaultTableModel tabla;
        tabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
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

    public DefaultTableModel totalAsuntosArea() throws SQLException {
        cabecera= new ArrayList<>();
        modelo.consultarAsuntosXArea c = new consultarAsuntosXArea(area);
        ArrayList<ArrayList> datos = c.getMatrix();
        DefaultTableModel tabla;
        tabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }

        };

        //cabecera.add("Total");
        tabla.addColumn("Asunto");
        tabla.addColumn("Total");
        datosAbajo = new int[datos.size()];
        for (int i = 0; i < datos.size(); i++) {
            cabecera.add(datos.get(i).get(0).toString());
            datosAbajo[i]= Integer.parseInt(datos.get(i).get(1).toString());
        }
        
        
        
        tabla.setRowCount(datos.size()+1);
        int total = 0;
        for (int i = 0; i < datos.size(); i++) {
            int numero = Integer.parseInt(datos.get(i).get(1).toString());
            total = total + numero;
            tabla.setValueAt(datos.get(i).get(0), i, 0);
            tabla.setValueAt(datos.get(i).get(1), i, 1);
        }
        //datosAbajo[cabecera.size()]=total;
        tabla.setValueAt("Total", datos.size(), 0);
        tabla.setValueAt(total, datos.size(), 1);
        return tabla;
    }

    public int[] getDatosAbajo() {
        return datosAbajo;
    }

    public ArrayList<String> getCabecera() {
        return cabecera;
    }

}
