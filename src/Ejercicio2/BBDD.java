package Ejercicio2;

import java.io.*;

public class BBDD {
    private static File f;
    private boolean ocupado = false;

    public BBDD(File f) {
        BBDD.f = f;
    }

    public synchronized void escribeEnFichero(String s) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(f, true))) {
            while (ocupado) {
                wait();
            }
            ocupado = true;
            Thread.sleep(1500);
            System.out.println("Escribiendo -> " + s);
            br.write(s + "\t");
            ocupado = false;
            notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void leeDeFichero() {
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            while (ocupado) {
                wait();
            }
            ocupado = true;
            Thread.sleep(1500);
            System.out.println("Leyendo");
            System.out.println(br.readLine());
            ocupado = false;
            notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
