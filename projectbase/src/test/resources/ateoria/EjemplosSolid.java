package examples;

public class EjemplosSolid {

    // ## S Principio de Responsabilidad Única: cada clase tiene una sola responsabilidad.

    // Mal ejemplo: Una clase que hace demasiado
    class EmpleadoMal {
        public void calcularSalario() { /* ... */ }
        public void guardarEnBaseDeDatos() { /* ... */ }
        public void generarInforme() { /* ... */ }
    }

    // Buen ejemplo: Clases con responsabilidades únicas
    class Empleado {
        public double calcularSalario() { /* ... */ return 0; }
    }

    class BaseDeDatosEmpleado {
        public void guardar(Empleado empleado) { /* ... */ }
    }

    class GeneradorInformes {
        public void generarInformeEmpleado(Empleado empleado) { /* ... */ }
    }

// ## O Principio Abierto/Cerrado

    // Mal ejemplo: Necesitamos modificar esta clase para cada nueva forma
    class CalculadorAreaMal {
        public double calcularArea(Object forma) {
            if (forma instanceof Rectangulo) {
                Rectangulo r = (Rectangulo) forma;
                return r.ancho * r.alto;
            }
            // Necesitamos añadir más 'if' para cada nueva forma
            return 0;
        }
    }

    // Buen ejemplo: Abierto para extensión, cerrado para modificación
    interface Forma {
        double calcularArea();
    }

    class Rectangulo implements Forma {
        double ancho, alto;
        public double calcularArea() { return ancho * alto; }
    }

    class Circulo implements Forma {
        double radio;
        public double calcularArea() { return Math.PI * radio * radio; }
    }

    class CalculadorArea {
        public double calcularArea(Forma forma) {
            return forma.calcularArea();
        }
    }

    // ## L Principio de Sustitución de Liskov

    // Mal ejemplo: Viola el principio de Liskov
    class Ave {
        public void volar() { /* ... */ }
    }

    class Pinguino extends Ave {
        @Override
        public void volar() {
            throw new UnsupportedOperationException("Los pingüinos no vuelan");
        }
    }

    // Buen ejemplo: Respeta el principio de Liskov
    interface AveQueVuela {
        void volar();
    }

    class Paloma implements AveQueVuela {
        public void volar() { /* ... */ }
    }

   /*  class Pinguino {
        // No tiene método volar
    }  */

// ## I Principio de Segregación de la Interfaz

    // Mal ejemplo: Interfaz demasiado grande
    interface TrabajadorMal {
        void trabajar();
        void comer();
        void dormir();
    }

    // Buen ejemplo: las interfaces están segregadas y las clases solo implementan lo que necesitan.
    interface Trabajable {
        void trabajar();
    }

    interface Comedor {
        void comer();
    }

    interface Durmiente {
        void dormir();
    }

    class Humano implements Trabajable, Comedor, Durmiente {
        public void trabajar() { /* ... */ }
        public void comer() { /* ... */ }
        public void dormir() { /* ... */ }
    }

    class Robot implements Trabajable {
        public void trabajar() { /* ... */ }
    }

// ## D  Principio de Inversión de Dependencia

    // Mal ejemplo: Dependencia directa en una implementación de bajo nivel
    class NotificadorMal {
        private EnviadorSMS enviadorSMS = new EnviadorSMS();

        public void notificar(String mensaje) {
            enviadorSMS.enviar(mensaje);
        }
    }

    // Buen ejemplo: Dependencia en una abstracción, Notificador depende de una abstracción (EnviadorNotificaciones) en lugar de una implementación concreta.
    interface EnviadorNotificaciones {
        void enviar(String mensaje);
    }

    class EnviadorSMS implements EnviadorNotificaciones {
        public void enviar(String mensaje) { /* ... */ }
    }

    class EnviadorEmail implements EnviadorNotificaciones {
        public void enviar(String mensaje) { /* ... */ }
    }

    class Notificador {
        private EnviadorNotificaciones enviador;

        public Notificador(EnviadorNotificaciones enviador) {
            this.enviador = enviador;
        }

        public void notificar(String mensaje) {
            enviador.enviar(mensaje);
        }
    }


}
