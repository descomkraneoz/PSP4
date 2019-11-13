package Ejercicio2;

public class Escritor extends Thread {
    private BBDD bd;
    private int identificador;

    public Escritor(BBDD bd, int id) {
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
                String s = "Escrito por " + getIdentificador();
                bd.escribeEnFichero(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
