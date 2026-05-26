/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author willi
 */
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author willi
 */
public class rederCombo extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int row, int colum) {
        //setHorizontalAlignment(SwingConstants.CENTER);
        //setHorizontalAlignment(SwingConstants.CENTER);
        if( o instanceof JButton){
           JButton btn = (JButton)o;
            return btn;
        }
       
        return super.getTableCellRendererComponent(jtable, o, bln, bln1, row, colum); //To change body of generated methods, choose Tools | Templates.
    }
}