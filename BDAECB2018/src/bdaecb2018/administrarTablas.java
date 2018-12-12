package bdaecb2018;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class administrarTablas {

    SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyy");
    Tablas tablas;
    private File archivo = null;

    public administrarTablas(String path) {
        archivo = new File(path);
    }

    public Tablas getTablas() {
        return tablas;
    }

    public void setTablas(Tablas tablas) {
        this.tablas = tablas;
    }

    public File getArchivo() {
        return archivo;
    }

    public void escribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);

            bw.write("#Encabezado\n");
            bw.write("nombre:" + tablas.getNombre() + "\n");
            bw.write("base_de_datos:" + tablas.getBd() + "\n");
            bw.write("creador:" + tablas.getCreador() + "\n");
            bw.write("fecha_creacion:" + f.format(tablas.getFecha_creacion()) + "\n");
            bw.write("atributos:");
            for (int i = 0; i < tablas.getAtributos().size(); i++) {
                if (i == tablas.getAtributos().size() - 1) {
                    bw.write(tablas.getAtributos().get(i) + "\n");
                } else {
                    bw.write(tablas.getAtributos().get(i) + ",");
                }
            }
            bw.write("#Detalles\n");
            for (int i = 0; i < tablas.getDetalle().size(); i++) {
                bw.write(tablas.getDetalle().get(i) + "\n");
            }

            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        bw.close();
        fw.close();
    }

    public void cargarArchivo() {
        Scanner sc = null;
        Scanner s2 = null;
        Scanner s3 = null;
        Date fechacreacion = new Date();        
        if (archivo.exists()) {
            try {
                sc = new Scanner(archivo);
                sc.useDelimiter("\n");
                while (sc.hasNext()) {
                    String pal = sc.next();
                    if (pal.equals("#Encabezado")) {
                        s2 = new Scanner(sc.next());
                        s2.useDelimiter(":");
                        s2.next();
                        String nombre = s2.next();
                        s2 = new Scanner(sc.next());
                        s2.useDelimiter(":");
                        s2.next();
                        String bd = s2.next();
                        s2 = new Scanner(sc.next());
                        s2.useDelimiter(":");
                        s2.next();
                        String creador = s2.next();
                        s2 = new Scanner(sc.next());
                        s2.useDelimiter(":");
                        s2.next();
                        s3 = new Scanner(s2.next());
                        s3.useDelimiter("/");
                        fechacreacion.setDate(s3.nextInt());
                        fechacreacion.setMonth(s3.nextInt());
                        fechacreacion.setYear(s3.nextInt());
                        s2 = new Scanner(sc.next());
                        s2.useDelimiter(":");
                        s2.next();
                        String atrib;
                        ArrayList<String> atributos = new ArrayList();
                        if (!((atrib = s2.next()) == null)) {
                            s2 = new Scanner(atrib);
                            s2.useDelimiter(",");
                            while (s2.hasNext()) {
                                atributos.add(s2.next());
                            }
                        }
                        sc.next();
                        ArrayList<String> detalle = new ArrayList();
                        while (sc.hasNext()) {
                            detalle.add(sc.next());
                        }         
                        tablas=new Tablas(nombre, creador, fechacreacion, bd);
                        tablas.setAtributos(atributos);
                        tablas.setDetalle(detalle);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("no lo lee");
            }
            sc.close();
        }
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    @Override
    public String toString() {
        return tablas.toString();
    }

}
