package Ejercicio2;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            File f = new File("prueba.txt");
            if (!f.exists()) {
                f.createNewFile();
            }
            BBDD bd = new BBDD(f);
            Lector[] lectores = new Lector[5];
            Escritor[] escritores = new Escritor[5];

            for (int i = 0; i < 5; i++) {
                lectores[i] = new Lector(bd, i);
                escritores[i] = new Escritor(bd, i);
            }
            for (int i = 0; i < 5; i++) {
                escritores[i].start();
                lectores[i].start();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
