package Ejercicio2;

public class Lector extends Thread {
    private BBDD bd;
    private int identificador;

    public Lector(BBDD bd, int id) {
        this.bd = bd;
        this.identificador = id;
    }

    public BBDD getBd() {
        return bd;
    }

    public int getIdentificador() {
        return identificador;
    }

    @Override
    public void run() {
        try {
            while (true) {
                bd.leeDeFichero();
                System.out.println("El lector número " + getIdentificador() + " ha leido");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
