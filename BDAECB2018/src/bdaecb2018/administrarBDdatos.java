/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdaecb2018;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author MBanegas
 */
public class administrarBDdatos {
        ArrayList<bdatos> basesdedatos = new ArrayList();
    File archivo = null;

    public administrarBDdatos(String Path) {
        archivo = new File(Path);
    }

    public ArrayList<bdatos> getBasesdedatos() {
        return basesdedatos;
    }

    public void setBasesdedatos(ArrayList<bdatos> basesdedatos) {
        this.basesdedatos = basesdedatos;
    }
    
    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public void setBasededatos(bdatos usuario) {
        basesdedatos.add(usuario);
    }

    public void cargarArchivo() {
        try {
            basesdedatos = new ArrayList();
            bdatos temp;
            if (archivo.exists()) {
                FileInputStream entrada
                        = new FileInputStream(archivo);
                ObjectInputStream objeto
                        = new ObjectInputStream(entrada);
                try {
                    while ((temp = (bdatos) objeto.readObject()) != null) {
                        basesdedatos.add(temp);
                    }
                } catch (EOFException e) {
                    //encontro el final del archivo
                }
                objeto.close();
                entrada.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void escribirArchivo() {
        FileOutputStream fw = null;
        ObjectOutputStream bw = null;
        try {
            fw = new FileOutputStream(archivo);
            bw = new ObjectOutputStream(fw);
            for (bdatos t : basesdedatos) {
                bw.writeObject(t);
            }
            bw.flush();
        } catch (Exception ex) {
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception ex) {
            }
        }
    }

}
