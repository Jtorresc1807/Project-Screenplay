package co.com.screenplay.project.utils;
//6

public class Time {         // Clase generica para las esperas

    private Time() {        //Constructor privado evita que se creen objetos de la clase Time
    }

    public static void waiting(int waiting) {
        try {
            Thread.sleep(waiting * 1000L);  //multiplica el valor de la constante TIME_SHORT * 1000L
        } catch (InterruptedException e) {      // Si sucede una interrupción captura la excepción InterruptedException
            e.printStackTrace();                // imprime la traza de la excepción
            Thread.currentThread().interrupt(); //Se interrumpe el hilo actual, indica q la espera ha sido interrumpida.
        }
    }
}
