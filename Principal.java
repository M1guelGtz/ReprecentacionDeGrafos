import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {           // Falta el Recorrido y ya queda
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int cantidad;
        Grafo grafo = new Grafo();
        System.out.print("\nIndica la cantidad de vértices del grafo: ");
        cantidad = validarEntero();

        for (int i = 0; i < cantidad; i++) {
            grafo.agregarNodo(crearVertice(grafo));
        }
        grafo.agregarAristas();
        System.out.println(grafo);
    }

    public static Vertice crearVertice(Grafo grafo) {
        Scanner entrada = new Scanner(System.in);
        int valorVertice;
        do {
            System.out.print("Ingresa el valor del vértice (múltiplo de 6): ");
            valorVertice = validarEntero();
            if (!multiploDeSeis(valorVertice)) {
                System.out.println("El valor ingresado no es múltiplo de 6. Intente nuevamente.");
            }
        } while (!multiploDeSeis(valorVertice));
        return new Vertice(valorVertice); 
    }

    public static int validarEntero() {
        int indice = 0;
        boolean excepcion = true;
        Scanner entrada = new Scanner(System.in);

        do {
            try {
                indice = entrada.nextInt();
                excepcion = false;
            } catch (InputMismatchException e) {
                System.out.println("----------¡Debe ser un número entero!--------\n");
                System.out.print("Vuelva a introducir la opción: ");
                entrada.next();
            }
        } while (excepcion);
        return indice;
    }

    public static boolean multiploDeSeis(int numero) {
        return numero % 6 == 0;
    }
}