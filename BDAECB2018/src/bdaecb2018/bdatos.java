/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdaecb2018;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author MBanegas
 */
public class bdatos implements Serializable{    
    String nombre;       
    ArrayList<Tablas>tablas=new ArrayList();
    Script usado;
    ArrayList<Usuarios> colaboradores = new ArrayList();
    
    private static final long SerialVersionUID=2;
    
    public bdatos(String nombre) {
        this.nombre = nombre;                
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Tablas> getTablas() {
        return tablas;
    }

    public void setTablas(ArrayList<Tablas> tablas) {
        this.tablas = tablas;
    }

    public Script getUsado() {
        return usado;
    }

    public void setUsado(Script usado) {
        this.usado = usado;
    }

    
    public ArrayList<Usuarios> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(ArrayList<Usuarios> colaboradores) {
        this.colaboradores = colaboradores;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
