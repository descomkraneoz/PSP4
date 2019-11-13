package Ejercicio1;

public class Main {
    public static void main(String[] args) {
        Silla s = new Silla();
        Palillo[] palillos = new Palillo[5];
        for (int i = 0; i < palillos.length; i++) {
            palillos[i] = new Palillo(i);
        }

        Filosofo[] filosofos = new Filosofo[5];
        for (int i = 0; i < filosofos.length; i++) {
            filosofos[i] = new Filosofo(i, palillos[i], palillos[(i + 1) % 5], s); //lo hacemos asi porque el segundo palillo solo llega a 4, el array va de 0 a 4 y por eso hacemos modulo
        }

        for (int i = 0; i < filosofos.length; i++) {
            filosofos[i].start();
        }

    }
}
