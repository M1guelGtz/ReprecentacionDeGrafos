import java.util.ArrayList;
import java.util.List;

public class Vertice{
    private int dato;
    private List<Arista> listaAristas;
    
    public Vertice(int dato) {
        this.dato = dato;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public List<Arista> getListaAristas() {
        return listaAristas;
    }

    public void setListaAristas(Arista aristas) {
        if (listaAristas == null) {
            listaAristas = new ArrayList<>();
        } 
        listaAristas.add(aristas);
    }
    
    @Override
    public String toString (){
        return "\n \t Vertice = "  +getDato() + ", Aristas = " + getListaAristas();
    }
}