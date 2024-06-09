import java.util.Scanner;
public class Principal{
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int cantidad;
        Grafo grafo = new Grafo();
        System.out.println("indica la cantidad de vertices del grafo: ");
        cantidad = entrada.nextInt();
        for (int i = 0; i < cantidad; i++) {
            grafo.agregarNodo(crearVertice(grafo));
        }
        grafo.agregarAristas();
        System.out.println(grafo);
    }
    public static Vertice crearVertice(Grafo grafo){
        Scanner entrada = new Scanner(System.in);
        System.out.println("ingresa el valor del vertice: ");
        Vertice nuevoVertice = new Vertice(entrada.next());
        return nuevoVertice;
    }
}