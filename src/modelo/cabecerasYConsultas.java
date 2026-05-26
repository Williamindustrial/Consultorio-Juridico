/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class cabecerasYConsultas {

    ArrayList<String> cabecera = new ArrayList();
    String consulta = "";

    public void cabecerasGrupoEtnico() {
        consulta = "SELECT usuarioatendido.Asunto,fichabibliografica.grupoEtnico, COUNT(fichabibliografica.grupoEtnico)as totalAño FROM fichabibliografica LEFT JOIN usuarioatendido on fichabibliografica.radicadoInterno= usuarioatendido.radicado WHERE usuarioatendido.fecha BETWEEN ? AND ? AND usuarioatendido.Asunto= ? AND usuarioatendido.area=? GROUP BY fichabibliografica.grupoEtnico";
        cabecera.add("Afrocolombiano");
        cabecera.add("Rom-gitano");
        cabecera.add("Raizal");
        cabecera.add("Palenquero");
        cabecera.add("Indigena");
        cabecera.add("Otro");
    }

    public void cabecerasSexo() {
        consulta = "SELECT usuarioatendido.Asunto,fichabibliografica.sexo, COUNT(fichabibliografica.sexo)as totalAño FROM fichabibliografica LEFT JOIN usuarioatendido on fichabibliografica.radicadoInterno= usuarioatendido.radicado WHERE usuarioatendido.fecha BETWEEN ? AND ? AND usuarioatendido.Asunto= ? AND usuarioatendido.area=? GROUP BY fichabibliografica.sexo";
        cabecera.add("Masculino");
        cabecera.add("Femenino");
        cabecera.add("Otro");
    }

    public void personasDiscapacitadas() {
        consulta = "SELECT usuarioatendido.Asunto,fichabibliografica.PersonaConDiscapacidad, COUNT(fichabibliografica.PersonaConDiscapacidad)as totalAño FROM fichabibliografica LEFT JOIN usuarioatendido on fichabibliografica.radicadoInterno= usuarioatendido.radicado WHERE usuarioatendido.fecha BETWEEN ? AND ? AND usuarioatendido.Asunto= ? AND usuarioatendido.area=? GROUP BY fichabibliografica.PersonaConDiscapacidad";
        cabecera.add("Sí");
        cabecera.add("No");
    }

    public void cualDiscapacidad() {
        consulta = "SELECT usuarioatendido.Asunto,fichabibliografica.CualDiscapacidad, COUNT(fichabibliografica.CualDiscapacidad)as totalAño FROM fichabibliografica LEFT JOIN usuarioatendido on fichabibliografica.radicadoInterno= usuarioatendido.radicado WHERE usuarioatendido.fecha BETWEEN ? AND ? AND usuarioatendido.Asunto= ? AND usuarioatendido.area=? GROUP BY fichabibliografica.CualDiscapacidad";
        cabecera.add("Fisica");
        cabecera.add("Auditiva");
        cabecera.add("Visual");
        cabecera.add("Sordoceguera");
        cabecera.add("Mental o psicosocial");
        cabecera.add("Intelectual o cognitiva");
        cabecera.add("Multiple");
    }

    public void victimaDelCOnflicto() {
        consulta = "SELECT usuarioatendido.Asunto,fichabibliografica.victimaConflictoArmado, COUNT(fichabibliografica.victimaConflictoArmado)as totalAño FROM fichabibliografica LEFT JOIN usuarioatendido on fichabibliografica.radicadoInterno= usuarioatendido.radicado WHERE usuarioatendido.fecha BETWEEN ? AND ? AND usuarioatendido.Asunto= ? AND usuarioatendido.area=?  GROUP BY fichabibliografica.victimaConflictoArmado";
        cabecera.add("Sí");
        cabecera.add("No");
    }
    public  void relacionConflictoDiscapacidad(){
        consulta="SELECT usuarioatendido.Asunto,fichabibliografica.relacionConflictoDiscapacidad, COUNT(fichabibliografica.relacionConflictoDiscapacidad)as totalAño FROM fichabibliografica LEFT JOIN usuarioatendido on fichabibliografica.radicadoInterno= usuarioatendido.radicado WHERE usuarioatendido.fecha BETWEEN ? AND ? AND usuarioatendido.Asunto= ? AND usuarioatendido.area=?  GROUP BY fichabibliografica.relacionConflictoDiscapacidad";
        cabecera.add("Sí");
        cabecera.add("No");
    }
    public  void estrato(){
        consulta="SELECT usuarioatendido.Asunto,fichabibliografica.Estrato, COUNT(fichabibliografica.Estrato)as totalAño FROM fichabibliografica LEFT JOIN usuarioatendido on fichabibliografica.radicadoInterno= usuarioatendido.radicado WHERE usuarioatendido.fecha BETWEEN ? AND ? AND usuarioatendido.Asunto= ? AND usuarioatendido.area=? GROUP BY fichabibliografica.Estrato";
        cabecera.add("0");
        cabecera.add("1");
        cabecera.add("2");
        cabecera.add("3");
    }
    public  void edad(){
        consulta="SELECT usuarioatendido.Asunto,fichabibliografica.Estrato, COUNT(fichabibliografica.Estrato)as totalAño FROM fichabibliografica LEFT JOIN usuarioatendido on fichabibliografica.radicadoInterno= usuarioatendido.radicado WHERE usuarioatendido.fecha BETWEEN ? AND ? AND usuarioatendido.Asunto= ? AND usuarioatendido.area=? GROUP BY fichabibliografica.Estrato";
        cabecera.add("0-26");
        cabecera.add("27-60");
        cabecera.add("61-Infinito");
    }

    public ArrayList<String> getCabecera() {
        return cabecera;
    }

    public String getConsulta() {
        return consulta;
    }

}
