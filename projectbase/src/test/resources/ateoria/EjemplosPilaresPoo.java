package examples;

public class EjemplosPilaresPoo {

    // ## Encapsulamiento: se logra usando modificadores de acceso como 'private' y métodos 'getter' y 'setter'.
    // En este ejemplo, 'saldo' es privado y solo se puede acceder o modificar a través de los métodos proporcionados.

    public class CuentaBancaria {
        private double saldo;  // El saldo está encapsulado

        public double getSaldo() {
            return saldo;
        }

        public void depositar(double cantidad) {
            if (cantidad > 0) {
                saldo += cantidad;
            }
        }
    }

    // ## Abstracción: nos permite: 1. Ocultar los detalles complejos y mostrar solo la funcionalidad al usuario.
    //                              2. Reducir la duplicación de código, ya que podríamos tener múltiples tipos de controles remotos que implementen la misma interfaz.
    //                              3. Facilitar los cambios, ya que podríamos cambiar la implementación interna sin afectar cómo se usa el control remoto.

    // Explicación: 1. La interfaz ControlRemoto es una abstracción. Define qué métodos debe tener un control remoto, pero no cómo deben implementarse.
    // 2. La clase ControlRemotoSony es una implementación concreta de esa abstracción. Proporciona el código real para cada método.
    // 3. En el main, usamos el control remoto sin preocuparnos por cómo funciona internamente. Solo sabemos que podemos llamar a métodos como encender() o cambiarCanal(), y el control hará su trabajo.
    // Esta es una interfaz que define los métodos que todo control remoto debe tener

    interface ControlRemoto {
        void encender();
        void apagar();
        void cambiarCanal(int canal);
        void subirVolumen();
        void bajarVolumen();
    }

    // Esta es una implementación concreta de un control remoto para una TV Sony
    class ControlRemotoSony implements ControlRemoto {
        @Override
        public void encender() {
            System.out.println("Encendiendo TV Sony");
            // Aquí iría el código específico para encender una TV Sony
        }

        @Override
        public void apagar() {
            System.out.println("Apagando TV Sony");
            // Aquí iría el código específico para apagar una TV Sony
        }

        @Override
        public void cambiarCanal(int canal) {
            System.out.println("Cambiando al canal " + canal + " en TV Sony");
            // Aquí iría el código específico para cambiar el canal en una TV Sony
        }

        @Override
        public void subirVolumen() {
            System.out.println("Subiendo volumen en TV Sony");
            // Aquí iría el código específico para subir el volumen en una TV Sony
        }

        @Override
        public void bajarVolumen() {
            System.out.println("Bajando volumen en TV Sony");
            // Aquí iría el código específico para bajar el volumen en una TV Sony
        }
    }

    // Código para usar el control remoto
    /* public class Main {
       /* public static void main(String[] args) {
            ControlRemoto miControl = new ControlRemotoSony();
            miControl.encender();
            miControl.cambiarCanal(5);
            miControl.subirVolumen();
            miControl.apagar();
        }
    }  */

    // ## Herencia: permite que una clase herede propiedades y métodos de otra.
    // 'Perro' hereda el método 'comer()' de 'Animal' y añade su propio método 'ladrar()'.

    // En este ejemplo, 'miAnimal' puede ser un 'Perro' o un 'Gato', y el método 'hacerSonido()'
    // se comporta de manera diferente dependiendo del tipo real del objeto.

    class Animal {
        void comer() {
            System.out.println("El animal está comiendo");
        }
    }

    class Perro extends Animal {
        void ladrar() {
            System.out.println("El perro está ladrando");
        }
    }

    // ## Polimorfismo: Permite que objetos de diferentes clases sean tratados de manera uniforme.

   /* class Animal {
        void hacerSonido() {
            System.out.println("El animal hace un sonido");
        }
    }  */

    /* class Perro extends Animal {
        @Override
        void hacerSonido() {
            System.out.println("El perro ladra");
        }
    }

    class Gato extends Animal {
        @Override
        void hacerSonido() {
            System.out.println("El gato maulla");
        }
    }

    // Uso del polimorfismo
    Animal miAnimal = new Perro();
miAnimal.hacerSonido();  // Imprime: "El perro ladra"

    miAnimal = new Gato();
miAnimal.hacerSonido();  // Imprime: "El gato maulla"  */








}
