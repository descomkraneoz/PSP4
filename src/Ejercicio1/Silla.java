package Ejercicio1;

public class Silla {
    private int sillaLibre = 4;

    public synchronized void cogerSilla(int i) throws InterruptedException {
        while (sillaLibre == 0) {
            wait();
            System.out.println("Filosofo " + i + " coge una silla");
            sillaLibre--;
        }
    }

    public synchronized void dejarSilla(int i) throws InterruptedException {
        sillaLibre++;
        System.out.println("Filosofo " + i + " suelta una silla");
        notify();
    }

}
