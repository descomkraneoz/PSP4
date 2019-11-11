package Ejercicio1;

/*https://pacoportillo.es/informatica-avanzada/programacion-multiproceso/la-cena-de-los-filosofos/#_Toc519449457*/

public class Main {
    public static void main(String[] args) {
        // Se crea el Array para contener las 5 instancias de Palillos:
        Palillo[] palillo = new Palillo[5];
        // Se crea el Array para contener las 5 instancias de Filósofos:
        Filosofo[] filosofo = new Filosofo[5];
        // Se crea una sola instancia de Monitor:
        MonitorComedor comensal = new MonitorComedor();
        // Se crean las 5 instancias de Palillos:
        for(int i=0; i<palillo.length; i++){
            palillo[i] = new Palillo(i);
        }

        // Se crean las 5 instancias de Filósofos:
        for(int i=0; i<filosofo.length; i++){
            /* El filósofo coge el palillo de la izquierda
             *  y el de la derecha se contabiliza con el módulo(%)
             *  porque cuando llega a cuatro el siguiente es cero
             */
            // Ahora al filósofo se le pasa: un ID, un palillo Derecho, un palillo Izdo y el comensal
            filosofo[i] = new Filosofo(i, palillo[i], palillo[(i+1)%5], comensal);

        // Se echa a andar todos los Filósofos:
        for(int j=0; j<filosofo.length; j++){
            filosofo[j].start();
        }
    }

    }
}
