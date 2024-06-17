import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Grafo {
    private List<Vertice> listaVertices;

    public Grafo() {
        listaVertices = new ArrayList<>();
    }

    public void agregarNodo(Vertice verticeNuevo) {
        int valor=0;
        for (Vertice verticeComp : listaVertices) {
            if (verticeComp.getDato()==verticeNuevo.getDato()) {
                do{
                    System.out.println("El vértice ya existe en el grafo.");
                    System.out.print("vuelva a introducir su eleccion:");
                    valor=decidir();
                    verticeNuevo.setDato(valor);
                }while(verticeComp.getDato()==verticeNuevo.getDato());
            }
        }
        listaVertices.add(verticeNuevo);
        System.out.println("Vertice Guardado");
    }

    public List<Vertice> getListaVertices() {
        return listaVertices;
    }

    public void agregarAristas() {
        int opcion, peso, count = 0;
        Vertice destino, origen;
        Scanner entrada = new Scanner(System.in);
        do {
            for (int i = 0; i < listaVertices.size(); i++) {
                System.out.println(i + 1 + ") " + listaVertices.get(i).getDato());
            }
            do {
                if (count != 0) {
                    System.out.println("-----Debe ser un índice mostrado en el menú-----");
                }
                System.out.print("SELECCIONE EL NÚMERO DEL VÉRTICE ORIGEN: ");
                opcion = decidir();
                count++;
            } while (opcion < 1 || opcion > listaVertices.size());
            count = 0;
            origen = listaVertices.get(opcion - 1);
            do {
                if (count != 0) {
                    System.out.println("-----Debe ser un índice mostrado en el menú-----");
                }
                System.out.print("INDIQUE EL NÚMERO DEL VÉRTICE DESTINO: ");
                opcion = decidir();
                count++;
            } while (opcion < 1 || opcion > listaVertices.size());
            count = 0;
            destino = listaVertices.get(opcion - 1);
            do {
                if (count != 0) {
                    System.out.println("-----EL PESO DEBE SER MAYOR A CERO-----");
                }
                System.out.print("INDIQUE EL PESO: ");
                peso = decidir();
                count++;
            } while (peso <= 0);
            if (!origen.equals(destino)) {
                Arista nuevaArista = new Arista(origen, destino, peso);
                if (!existeArista(nuevaArista)) {
                    origen.setListaAristas(nuevaArista);
                } else {
                    System.out.println("ERROR: La arista ya existe en el grafo.\n");
                }
            } else {
                System.out.println("ERROR: El origen y destino son el mismo.\n");
            }
            System.out.print("Desea agregar otra arista? (1. Sí\t 2. No): ");
            opcion = decidir();
        } while (opcion == 1);
    }

    
    public boolean existeArista(Arista arista) {
        for (Vertice v : listaVertices) {
            if (v.getListaAristas() != null) {
                for (Arista a : v.getListaAristas()) {
                    if (a.equals(arista)) {
                        return true;
                    }
                }
            }
        }
        return false;
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
                System.out.println("----------¡Debe ser un numero entero!--------\n");
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