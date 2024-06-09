import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class Grafo {
    private List<Vertice> listaVertices;
    public void agregarNodo(Vertice verticeNuevo){
        if (listaVertices == null) {
            listaVertices = new ArrayList<>();
        }
        listaVertices.add(verticeNuevo);
    }
    public List<Vertice> getListaVertices() {
        return listaVertices;
    }
    public void agregarAristas(){
        int opcion, peso, count = 0;
        Vertice destino, origen;
        Scanner entrada = new Scanner(System.in);
        do{
            for (int i = 0; i < listaVertices.size(); i++) {
                System.out.println( i + 1 + ") " + listaVertices.get(i).getDato());
            }
            do{
                if (count != 0) {
                    System.out.println("-----debe ser un indice mostrado en el menu-----");
                }
                System.out.print("SELECCIONE EL NUMERO DEL VERTICE ORIGEN: " );
                opcion = decidir();
                count ++;
            }while(opcion >= listaVertices.size()+1);
            count = 0;
            origen = listaVertices.get( opcion - 1);
            do{
                if (count != 0) {
                    System.out.println("-----debe ser un indice mostrado en el menu-----");
                }
                System.out.print("INDIQUE EL NUMERO DEL VERTICE DESTINO: " );
                opcion = decidir();
                count ++;
            }while(opcion >= listaVertices.size()+1);
            count = 0;
            destino = listaVertices.get( opcion - 1);
            do{
                if (count != 0) {
                    System.out.println("-----EL PESO DEBE SER MAYOR A CERO-----");
                }
                System.out.print("INDIQUE EL PESO: ");
                peso = decidir();
                count++;
            }while (peso <= 0);
            origen.setListaAristas(new Arista(origen, destino, peso));
            System.out.print("agregar mas aristas (1. Si\t 2. No)? ");
            opcion = decidir();
        }while(opcion == 1);
    }
    @Override
    public String toString (){
        return " GRAFO [ " + getListaVertices() + "\n ]";
    }
    public int decidir(){
        int indice = 0;
        boolean excepcion = true;
        do{
            try{
                indice = validarEleccion();
                excepcion = false;
            }catch(InputMismatchException e){
                System.out.println("----------¡Debe ser un numero entero!--------\\n");
                System.out.print("vuelva a introducir la opcion: ");
            }
            
        }while(excepcion);
        
        return indice;
    } 

    public int validarEleccion() throws InputMismatchException{
        Scanner entrada = new Scanner(System.in);
        int eleccion = entrada.nextInt();
        return eleccion;
    }
}