import java.util.*;
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
            System.out.println("SELECCIONE EL NUMERO DEL VERTICE ORIGEN: " );
            opcion = entrada.nextInt();
            origen = listaVertices.get( opcion - 1);
            System.out.println("INDIQUE EL NUMERO DEL VERTICE DESTINO: " );
            opcion = entrada.nextInt();
            destino = listaVertices.get( opcion - 1);
            do{
                if (count != 0) {
                    System.out.println("-----EL PESO DEBE SER MAYOR A CERO-----");
                }
                System.out.println("INDIQUE EL PESO: ");
                peso = entrada.nextInt();
                count++;
            }while (peso <= 0);
            origen.setListaAristas(new Arista(origen, destino, peso));
            System.out.println("agregar mas aristas? 1. Si\t 2. No");
            opcion = entrada.nextInt();
        }while(opcion == 1);
    }
    @Override
    public String toString (){
        return " GRAFO [ " + getListaVertices() + "\n ]";
    }
}