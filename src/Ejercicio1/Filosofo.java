package Ejercicio1;

public class Filosofo extends Thread {
    private int id;
    private Palillo izquierdo, derecho;
    private Silla s;

    public Filosofo(int id, Palillo izquierdo, Palillo derecho, Silla s) {
        this.id = id;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
        this.s = s;
    }

    public void run(){
        while (true) {
            try {
                //El filosodo se sienta a la mesa
                System.out.println("El Filósofo " + id + " se sienta a la mesa");
                s.cogerSilla(id);
                //Coge los palillos
                izquierdo.cogePalillo(id);
                derecho.cogePalillo(id);
                System.out.println("Filósofo " + id + " se pone a comer");
                Thread.sleep((int) (Math.random() * 5000));
                System.out.println("Filósofo " + id + " termina de comer");
                //termina de comer y suelta los palillos y la silla
                derecho.dejaPalillo(id);
                izquierdo.dejaPalillo(id);
                s.dejarSilla(id);
                System.out.println("Filósofo " + id + " se pone a pensar");
                Thread.sleep((int) (Math.random() * 3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
