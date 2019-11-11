package Ejercicio1;

import java.util.Random;

public class Filosofo extends Thread {
    // Variable para generar números aleatorios:
    private Random random = new Random();
    // Variable para la ID del Filósofo:
    private int id;
    // Variables para los palillos:
    private Palillo izquierda, derecha;
    // Variable para el comensal:
    private MonitorComedor monitor;
    // Variable pública y estática para que se pueda detener el método run() de esta clase:
    public static boolean finalizado = false;

    public Filosofo(int id, Palillo derecha, Palillo izquierda, MonitorComedor monitor){
        // Se asignan los valores recibidos a las variables
        this.id = id;
        this.derecha = derecha;
        this.izquierda = izquierda;
        this.monitor = monitor;
    }

    /**
     * Método que se ejecuta indefinidamente, una por cada hilo creado
     */
    @Override
    public void run(){
        while(true){ // Se repite infinitamente While

            try { // try / catch
                // Obtener el comensal para poder comer:
                monitor.cogerComensal(id);
                // Obtener el Palillo Derecho:
                derecha.cogerPalillo(id);
                // Obtener el Palillo Izquierdo:
                if (!izquierda.cogerPalilloIzquierdo(id)){
                    // -----------------------------------------------------------------------------------------------------------------
                    // Si no se consigue el izquierdo: el filósofo tendra que volver a casilla de salida y volver a obtener el comensal:
                    System.out.println("El Filósofo " + (id+1) + " tendrá que soltar el tenedor " + (id+1) + " por exceso de tiempo y salir a pensar.");
                    // Como no ha conseguido el Palillo izquierdo suelta el derecho
                    derecha.soltarPalillo(id);
                    // Como no ha conseguido el Palillo izquierdo suelta el comensal
                    monitor.soltarComensal(id);
                    // Y ahora el Filósofo piensa *********************
                    System.out.println("El Filósofo " + (id+1) + " está pensando.");
                    try {
                        // El tiempo que tarda el filósofo en pensar, entre 100 y 1000 milisegundos:
                        Filosofo.sleep(random.nextInt(1000) + 100);
                    } catch (InterruptedException ex) {
                        System.out.println("Error. Descripción: " + ex.toString());
                    }
                    // Fin de Ahora el Filósofo piensa *********************
                    continue; // Se vuelve a poner en la casilla de salida y volver a obtener el comensal.
                    // -----------------------------------------------------------------------------------------------------------------
                }
                // Si ha conseguido el Palillo Izquierdo. El filósofo sigue adelante:
                // Y ahora el Filósofo come =========================================================================================
                System.out.println("El Filósofo " + (id+1) + " está comiendo.");
                // Simular el tiempo que tarda el filósofo en comer, entre 0.5 y 1 segundos:
                try {
                    sleep(random.nextInt(1000) + 500);
                } catch (InterruptedException ex) {
                    System.out.println("Error. Descripción: " + ex.toString());
                } // Fin de Simular el tiempo que tarda el filósofo en comer, entre 0.5 y 1 segundos

                // Fin de Ahora el Filósofo come ====================================================================================
                // Suelta el Palillo izquierdo:
                izquierda.soltarPalillo(id);
                // Suelta el Palillo derecho:
                derecha.soltarPalillo(id);
                // Suelta el comensal:
                monitor.soltarComensal(id);
                // Ahora el Filósofo piensa *********************************************************************************************
                System.out.println("El Filósofo " + (id+1) + " está pensando.");
                // El tiempo que tarda el filósofo en pensar, entre 100 y 1000 milisegundos:
                try {
                    Filosofo.sleep(random.nextInt(1000) + 100);
                } catch (InterruptedException ex) {
                    System.out.println("Error. Descripción: " + ex.toString());
                }
                // Fin de Ahora el Filósofo piensa **************************************************************************************
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                System.err.println("Se ha producido un error. Descripción: " + ex.toString());
            } // Fin del try / catch

            //Salgo de la aplicación, por comprobar

            //finalizado=true;
            if(finalizado){
                System.out.println("La cena ha terminado para todos: El Filósofo " + (id+1) +" se ha puesto a pensar.");
                break; // Se sale

            }

        }  // Fin de Se repite infinitamente While


    }


}
