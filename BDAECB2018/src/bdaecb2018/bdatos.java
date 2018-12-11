/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdaecb2018;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author MBanegas
 */
public class bdatos implements Serializable{

    String nombre;   
    Usuarios usuario;    
    ArrayList<String> scripts = new ArrayList();
    ArrayList<Usuarios> colaboradores = new ArrayList();
    
    private static final long SerialVersionUID=2;
    
    public bdatos(String nombre,Usuarios usuario) {
        this.nombre = nombre;        
        this.usuario=usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public ArrayList<String> getScripts() {
        return scripts;
    }

    public void setScripts(ArrayList<String> scripts) {
        this.scripts = scripts;
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
