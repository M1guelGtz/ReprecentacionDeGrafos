import java.util.InputMismatchException;
import java.util.Scanner;
public class Principal{
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int cantidad;
        Grafo grafo = new Grafo();
        System.out.print("\nindica la cantidad de vertices del grafo: ");
        cantidad = decidir();
        for (int i = 0; i < cantidad; i++) {
            grafo.agregarNodo(crearVertice(grafo));
        }
        grafo.agregarAristas();
        System.out.println(grafo);
    }
    public static Vertice crearVertice(Grafo grafo){
        Scanner entrada = new Scanner(System.in);
        System.out.print("ingresa el valor del vertice: ");
        Vertice nuevoVertice = new Vertice(entrada.next());
        return nuevoVertice;
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
        int eleccion = entrada.nextInt();
        return eleccion;
    }
}