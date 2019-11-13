package Ejercicio1;

/**
 * Recurso compratido por los hilos Filósofos,
 * Cada palillo tiene su ID y a cada filósofo le corresponde 2 palillos concretos.
 */

public class Palillo {

    private int id;
    private boolean palilloLibre = true;

    public Palillo(int id){
        this.id = id;
    }

    public synchronized void cogePalillo(int i) throws InterruptedException {
        while (!palilloLibre) {
            wait();
            System.out.println("Filosofo " + i + " coge el palillo " + id);
            palilloLibre = false;
        }
    }

    public synchronized void dejaPalillo(int i) throws InterruptedException {
        palilloLibre = true;
        System.out.println("Filosofo " + i + " Suelta el palillo " + id);
        //notifyAll();
        notify();
    }

}
