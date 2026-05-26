/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import com.toedter.calendar.JDateChooser;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.*;

/**
 *
 * @author Julian Navarro
 */
public class AddPersona {

    javax.swing.JTextField Japellidos;
    javax.swing.JTextField Jcedula;
    javax.swing.JTextField Jcelular;
    javax.swing.JTextField Jdireccion;
    javax.swing.JComboBox<String> Jestrato;
    com.toedter.calendar.JDateChooser JfechaNacimiento;
    javax.swing.JTextField Jnombres;
    javax.swing.JComboBox<String> Jescolaridad;
    javax.swing.JTextField Jocupación;
    javax.swing.JTextField Jtelefono,Jradicado;
    javax.swing.JCheckBox jCheckBox1;
    javax.swing.ButtonGroup JcualDiscapacidad, Jdiscapacidad, JdiscapacidadPorConflictoArmado, JgrupoEtnico, Jvictimadelconflicto, Jsexo;
    boolean cerrar = false;
    boolean acepta=false;
    int estrato, edad;
    long cedulaUsuario, telefono, celular;
    String nombres, apellidos, dirección, gradoEscolaridad, ocupación, fechaNacimiento, sexo, grupoEtnico, PersonaConDiscapacidad, CualDiscapacidad, victimaConflictoArmado, relacionConflictoDiscapacidad;

    public AddPersona(JTextField Japellidos, JTextField Jcedula, JTextField Jcelular, JTextField Jdireccion, JComboBox<String> Jestrato, JDateChooser JfechaNacimiento, JTextField Jnombres, JComboBox<String> Jescolaridad, JTextField Jocupación, JTextField Jtelefono, ButtonGroup JcualDiscapacidad, ButtonGroup Jdiscapacidad, ButtonGroup JdiscapacidadPorConflictoArmado, ButtonGroup JgrupoEtnico, ButtonGroup Jvictimadelconflicto, ButtonGroup Jsexo, JCheckBox jCheckBox1, JTextField Jradicado) throws SQLException {
        this.Japellidos = Japellidos;
        this.Jcedula = Jcedula;
        this.Jcelular = Jcelular;
        this.Jdireccion = Jdireccion;
        this.Jestrato = Jestrato;
        this.JfechaNacimiento = JfechaNacimiento;
        this.Jnombres = Jnombres;
        this.Jescolaridad = Jescolaridad;
        this.Jocupación = Jocupación;
        this.Jtelefono = Jtelefono;
        this.JcualDiscapacidad = JcualDiscapacidad;
        this.Jdiscapacidad = Jdiscapacidad;
        this.JdiscapacidadPorConflictoArmado = JdiscapacidadPorConflictoArmado;
        this.JgrupoEtnico = JgrupoEtnico;
        this.Jvictimadelconflicto = Jvictimadelconflicto;
        this.Jsexo = Jsexo;
        this.jCheckBox1= jCheckBox1;
        this.Jradicado= Jradicado;
        add();
    }

    private void add() throws SQLException {
        try {
            apellidos = Japellidos.getText();
            cedulaUsuario = Long.valueOf(this.Jcedula.getText());
            celular = Long.valueOf(this.Jcelular.getText());
            dirección = this.Jdireccion.getText();
            estrato = Integer.parseInt(this.Jestrato.getSelectedItem().toString());
            String day = JfechaNacimiento.getDateFormatString();
            JTextField fechaI = (JTextField) (JfechaNacimiento.getDateEditor().getUiComponent());
            fechaNacimiento = fechaI.getText();
            nombres = this.Jnombres.getText();
            gradoEscolaridad = (String) this.Jescolaridad.getSelectedItem();
            String radicado= Jradicado.getText();
            try {
                telefono = Long.valueOf(this.Jtelefono.getText());
            } catch (Exception e) {
                telefono=0;
            }
            ocupación = this.Jocupación.getText();
            Connection miConecion = conectarBd.miConeccion;
            if (nombres.equalsIgnoreCase("") || ocupación.equalsIgnoreCase("") || gradoEscolaridad.equalsIgnoreCase("") || dirección.equalsIgnoreCase("") || apellidos.equalsIgnoreCase("")|| radicado.equalsIgnoreCase("")) {
                Icon error = new ImageIcon(getClass().getResource("/folder/dok.png"));
                JOptionPane.showMessageDialog(null, "Datos incompletos", "ERROR", WIDTH, error);
            } else {
                todosGroup();
                addPersona add = new addPersona(estrato, edad, cedulaUsuario, telefono, celular, nombres, apellidos, dirección, gradoEscolaridad, ocupación, fechaNacimiento, sexo, grupoEtnico, PersonaConDiscapacidad, CualDiscapacidad, victimaConflictoArmado, relacionConflictoDiscapacidad, acepta,radicado,miConecion);
                add.agregar();
                cerrar = true;
            }

        } catch (Exception e) {
            Icon error = new ImageIcon(getClass().getResource("/folder/dok.png"));
            JOptionPane.showMessageDialog(null, "Verifique los campos", "ERROR", WIDTH, error);
            e.printStackTrace();
        }

    }

    public boolean isCerrar() {
        return cerrar;
    }

    public void sexo() {
        for (Enumeration<AbstractButton> buttons = Jsexo.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                sexo = button.getText();
            }
        }
    }

    public void grupoEtnico() {
        for (Enumeration<AbstractButton> buttons = JgrupoEtnico.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                grupoEtnico = button.getText();
            }
        }
    }

    public void personaConDiscapacidad() {
        for (Enumeration<AbstractButton> buttons = Jdiscapacidad.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                PersonaConDiscapacidad = button.getText();
            }
        }
    }

    public void CualDiscapacidad() {
        for (Enumeration<AbstractButton> buttons = JcualDiscapacidad.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                CualDiscapacidad = button.getText();
            }
        }
    }

    public void VictimaConflictoArmado() {
        for (Enumeration<AbstractButton> buttons = Jvictimadelconflicto.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                victimaConflictoArmado = button.getText();
            }
        }
        //return victimaConflictoArmado;
    }

    public void RelacionConflictoDiscapacidad() {
        for (Enumeration<AbstractButton> buttons = JdiscapacidadPorConflictoArmado.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                relacionConflictoDiscapacidad = button.getText();
            }
        }
        // return relacionConflictoDiscapacidad;
    }

    private void todosGroup() {
        CualDiscapacidad();
        RelacionConflictoDiscapacidad();
        VictimaConflictoArmado();
        grupoEtnico();
        personaConDiscapacidad();
        sexo();
        edad();
        acepto();
    }

    void edad() {
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd ");
        JTextField fechaI = (JTextField) (JfechaNacimiento.getDateEditor().getUiComponent());
        String fecha_nacimiento = fechaI.getText();
        String N = "";

        for (int i = 0; i < fecha_nacimiento.toCharArray().length; i++) {

        }
        LocalDate FechaNacimiento = LocalDate.parse(fecha_nacimiento, date);
        LocalDate fechaActual = LocalDate.now();

        Period periodo = Period.between(FechaNacimiento, fechaActual);
        edad = periodo.getYears();

    }
    
    void acepto(){
       acepta= jCheckBox1.isSelected();
    }

}
