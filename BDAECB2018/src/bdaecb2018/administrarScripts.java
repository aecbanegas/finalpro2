/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdaecb2018;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author MBanegas
 */
public class administrarScripts {

    Script actual;
    File archivo;

    public administrarScripts(String path) {
        archivo=new File(path);
    }

    public Script getActual() {
        return actual;
    }

    public void setActual(Script actual) {
        this.actual = actual;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public void escribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw=new FileWriter(archivo);
            bw=new BufferedWriter(fw);
            for (int i = 0; i < actual.getSqlused().size(); i++) {
                bw.write(actual.getSqlused().get(i)+"\n");
            }
            bw.flush();
        } catch (Exception e) {
        }
        fw.close();
        bw.close();
    }
    public void cargarArchivo(){
        Scanner sc = null;    
        actual=new Script();
        if (archivo.exists()) {
            try {
                sc = new Scanner(archivo);
                sc.useDelimiter("\n");
                while (sc.hasNext()) {                    
                    actual.getSqlused().add(sc.next());
                }                
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("no lo lee");
            }
            sc.close();
        }
    }
}
