package Ejercicio1;

import java.util.Random;

/**
 * Recurso compratido por los hilos Filósofos,
 * Se crean 5 instancias con n-1 comensales donde n es el número de filósofoscon el total de los palillos,
 * Cada palillo tiene su ID y a cada filósofo le corresponde 2 palillos concretos.
 */

public class Palillo {

    // Variable para generar números aleatorios:
    private Random random = new Random();
    // ID del Palillo
    private int id;
    // Está ocupado el palillo o no?:
    private boolean PalilloLibre = true;

    //Constructor
    public Palillo(int id){
        this.id = id;
    }

    // Crear métodos synchronized => Monitores
    // Solo puede acceder un Thread a la vez.
    /**
     * Monitor para coger el palillo derecho y poder seguir el proceso de ejecución de los filósofos.
     */
    public synchronized void cogerPalillo(int idFilosofo) throws InterruptedException{
        while(!PalilloLibre)
            this.wait();
        System.out.println("El Filósofo " + (idFilosofo+1) + " coge el palillo " + (id+1));
        PalilloLibre = false;
    }

    /**
     * Monitor para coger el palillo izquierdo y poder seguir el proceso de ejecución de los filósofos,
     * Pero si no consigue cogerlo en un tiempo x retornará false y tendra que salir a pensar y no podra comer,
     * Tendrá que volver a empezar el proceso de comer.
     */
    public synchronized boolean cogerPalilloIzquierdo(int idFilosofo) throws InterruptedException{
        while(!PalilloLibre){
            this.wait(random.nextInt(1000) + 500); // Sólo espera aleatoriamente entre 0.5 y 1 seg y si no, retorna false
            return false;
        }
        System.out.println("El Filósofo " + (idFilosofo+1) + " coge el palillo " + (id+1));
        PalilloLibre = false;
        return true;
    }

    /**
     * Monitor para soltar un palillo izquierdo o derecho y salir a pensar.
     */
    public synchronized void soltarPalillo(int idFilosofo) throws InterruptedException {
        PalilloLibre = true;
        System.out.println("El Filósofo " + (idFilosofo+1) + " suelta el palillo " + (id+1));
        this.notify();
    }

}
