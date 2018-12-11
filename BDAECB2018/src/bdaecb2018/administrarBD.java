/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdaecb2018;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author MBanegas
 */
public class administrarBD {

    File archivo;
    ArrayList<bdatos> actual=new ArrayList();
    String path;

    public administrarBD(String path) {
        archivo = new File(path);
        this.path = path;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public ArrayList<bdatos> getActual() {
        return actual;
    }

    public void setActual(ArrayList<bdatos> actual) {
        this.actual = actual;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void escribirArchivo() {
        try {
            for (int i = 0; i < actual.size(); i++) {
                String nom = actual.get(i).getNombre();
                File aqui = new File(path + "/" + nom);
                if (aqui.exists()) {
                } else {
                    aqui.mkdir();
                }
                administrarScripts as = new administrarScripts(path + "/" + nom + "/Scripts.txt");
                as.setActual(actual.get(i).getUsado());
                as.escribirArchivo();
                for (int j = 0; j < actual.get(i).getTablas().size(); j++) {
                    administrarTablas at = new administrarTablas(path + "/" + nom + "/" + actual.get(i).getTablas().get(j).getNombre()+".txt");
                    at.setTablas(actual.get(i).getTablas().get(j));
                    at.escribirArchivo();
                }
                administrarUsuarios au = new administrarUsuarios(path + "/" + nom + "/Usuarios.BDAECB");
                au.setUsuarios(actual.get(i).getColaboradores());
                au.escribirArchivo();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cargarArchivo() {
        try {
            File[]list=archivo.listFiles();
            File[]list2;
            ArrayList<Usuarios>usus=new ArrayList();            
            Tablas tabs;
            Script here=new Script();
            for (int i = 0; i < list.length; i++) {
                list2=list[i].listFiles();
                ArrayList<Tablas>para=new ArrayList();
                for (int j = 0; j < list2.length; j++) {
                    if (list2[j].getName().equals("Usuarios.BDAECB")) {
                        administrarUsuarios au=new administrarUsuarios(path+"/"+list[i].getName()+"/"+list2[j].getName());
                        au.cargarArchivo();
                        usus=au.getUsuarios();
                    }else if (list2[j].getName().equals("Scripts.txt")) {
                        administrarScripts as=new administrarScripts(path+"/"+list[i].getName()+"/"+list2[j].getName());
                        as.cargarArchivo();
                        here=as.getActual();
                    }else{
                        administrarTablas at=new administrarTablas(path+"/"+list[i].getName()+"/"+list2[j].getName());
                        at.cargarArchivo();
                        tabs=at.getTablas();
                        para.add(tabs);
                    }
                }
                bdatos agrego=new bdatos(list[i].getName());
                agrego.setColaboradores(usus);
                agrego.setTablas(para);
                agrego.setUsado(here);
                actual.add(agrego);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
