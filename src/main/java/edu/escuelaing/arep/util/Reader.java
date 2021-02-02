package edu.escuelaing.arep.util;
import java.io.*;

/**
 * Lector de archivos
 *
 * Autor: Juan Sebastian Ramos Isaza
 */
public class Reader {


    public static LinkedList<Double> lector(String file) {
        LinkedList<Double> valores = new LinkedList<Double>();
        try {
            File f = new File(file);
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            String cadena;
            cadena = bf.readLine();
            int cantidad = Integer.parseInt(cadena);
            for (int i = 0; i < cantidad; i++) {
                cadena = bf.readLine();
                Double temp = Double.parseDouble(cadena);
                valores.add(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return valores;
    }
}


