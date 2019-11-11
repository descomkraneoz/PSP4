package Ejercicio1;

public class MonitorComedor {

    private int comensal = 4; // Es el número de comensales total de filósofos menos 1

    /**
     * Monitor para coger un comensal de los 4 y poder seguir el proceso de ejecución de los filósofos.
     */

     public synchronized void cogerComensal(int idFilosofo) throws InterruptedException{
        while(comensal==0){ // Si no hay comensales libres toca esperar
            this.wait();
        }
        System.out.println("El Filósofo " + (idFilosofo+1) + " es el comensal " + comensal);

        comensal--; // Conteo de comensales
    }

    /**
     * Monitor para soltar un comensal de los 4 y poder seguir el proceso de ejecución de los filósofos.
     */
    public synchronized void soltarComensal(int idFilosofo) throws InterruptedException{
        comensal++; // Conteo de comensales
        System.out.println("El Filósofo " + (idFilosofo+1) + " ya NO es el comensal " + comensal);
        // Siempre se valora si el log es distinto a null, si lo es se ecribe en la interface gráfica:

        this.notify(); // Notificación al siguiente de que hay comensal disponible.
    }

}
