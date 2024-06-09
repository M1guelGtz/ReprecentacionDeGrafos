import java.util.*;
public class Vertice{
    private String dato;
    private List<Arista> listaAristas;
    public Vertice(String valor){
        this.dato = valor;
    }
    public String getDato() {
        return dato;
    }
    public void setDato(String dato) {
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