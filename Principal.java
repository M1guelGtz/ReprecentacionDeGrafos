import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {          
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int cantidad;
        System.out.print("\nIndica la cantidad de vértices del grafo: ");
        Grafo grafo = new Grafo();
        cantidad = decidir();
        for (int i = 0; i < cantidad; i++) {
            grafo.agregarNodo(crearVertice(grafo));
        }
        grafo.agregarAristas();
        
        grafo.recorridoEnAnchura();
        grafo.recorrerGrafo(grafo.getListaVertices().get(0).getDato());
        System.out.println(grafo);
    }
    public static Vertice crearVertice(Grafo grafo) {
        Scanner entrada = new Scanner(System.in);
        int valorVertice;
        do {
            System.out.print("\nIngresa el valor del vértice (múltiplo de 6): ");
            valorVertice = decidir();
            if (!multiploDeSeis(valorVertice, grafo)) {
                System.out.println("El valor ingresado no es múltiplo de 6. Intente nuevamente.");
            }
        } while (!multiploDeSeis(valorVertice, grafo));
        Vertice nuevo = new Vertice(valorVertice);
        return nuevo;
    }

    public static int decidir(){
        int indice = 0;
        boolean excepcion = true;
        do{
            try{
                indice = validarEleccion();
                excepcion = false;
            }catch(InputMismatchException e){
                System.out.println("----------¡Debe ser un numero entero!--------\n");
                System.out.print("vuelva a introducir la opcion: ");
            }
        }while(excepcion);
        return indice;
    } 

    public static int validarEleccion() throws InputMismatchException{
        Scanner entrada = new Scanner(System.in);
        int eleccion, count=0;
        do{
            if(count != 0){
                System.out.println("-------Debe ser un número mayor a cero------");
                System.out.print("introduzca su eleccion:");
            }
            count++;
            eleccion = entrada.nextInt();
        }while(eleccion <= 0);
        return eleccion;
    }

    public static boolean multiploDeSeis(int numero, Grafo grafo) {
        return numero % 6 == 0;
    }
}