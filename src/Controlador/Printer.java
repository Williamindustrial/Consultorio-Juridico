/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Asus
 */
public final class Printer {

    ArrayList<String> cabecera;
    int[] datos;
    String titulo, label;

   
    public JPanel createDemoPanel() {
        DefaultCategoryDataset categoria = new DefaultCategoryDataset();
        String m = "";
        for (int i = 0; i < cabecera.size(); i++) {
            categoria.setValue(datos[i], cabecera.get(i), "");

        }
       //JFreeChart f = ChartFactory.createBarChart(label, titulo,"Cantidad", categoria);
        JFreeChart f = ChartFactory.createBarChart3D(label, titulo,"Cantidad", categoria);
        f.setBackgroundPaint(Color.white);
        f.getPlot().setBackgroundPaint(Color.white);
        ChartPanel panel = new ChartPanel(f);
        panel.setMouseWheelEnabled(true);
        return panel;
    }

    public Printer(JPanel printer, ArrayList<String> cabecera, int [] datos, String titulo, String label) {
        this.cabecera = cabecera;
        this.datos = datos;
        this.titulo = titulo;
        this.label= label;
        printer.removeAll();
        JPanel jPanelPrinter = createDemoPanel();
        jPanelPrinter.setPreferredSize(new java.awt.Dimension(300, 500));
        jPanelPrinter.updateUI();
        JButton j = new JButton();
        printer.add(j);
        printer.repaint();
        printer.updateUI();
        printer.revalidate();

        //chartPanel.updateUI();
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(printer);
        printer.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanelPrinter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanelPrinter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
    }

}
