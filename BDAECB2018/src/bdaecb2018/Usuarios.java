/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdaecb2018;

import java.io.Serializable;

/**
 *
 * @author MBanegas
 */
public class Usuarios implements Serializable{
    private String usuario;
    private String contra;
    private boolean admin;
    private boolean create;
    private boolean select;
    private boolean insert;
    private boolean delete;
    private boolean drop;
    private static final long SerialVersionUID=1;

    public Usuarios(String usuario, String contra, boolean admin, boolean create, boolean select, boolean insert, boolean delete, boolean drop) {
        this.usuario = usuario;
        this.contra = contra;
        this.admin = admin;
        this.create = create;
        this.select = select;
        this.insert = insert;
        this.delete = delete;
        this.drop = drop;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    
    
    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isCreate() {
        return create;
    }

    public void setCreate(boolean create) {
        this.create = create;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public boolean isInsert() {
        return insert;
    }

    public void setInsert(boolean insert) {
        this.insert = insert;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public boolean isDrop() {
        return drop;
    }

    public void setDrop(boolean drop) {
        this.drop = drop;
    }

    @Override
    public String toString() {
        return "Usuario= " + usuario;
    }
    
    
}
