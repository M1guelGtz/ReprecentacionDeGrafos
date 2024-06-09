public class Arista {
    private Vertice inicio;
    private Vertice fin;
    private int peso;
    public Arista(Vertice origen, Vertice destino, int valor){
        this.inicio = origen;
        this.fin = destino;
        this.peso = valor;
    }
    public Vertice getInicio() {
        return inicio;
    }
    public void setInicio(Vertice inicio) {
        this.inicio = inicio;
    }
    public Vertice getFin() {
        return fin;
    }
    public void setFin(Vertice fin) {
        this.fin = fin;
    }
    public int getPeso() {
        return peso;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
    @Override
    public String toString(){
        return "[" + inicio.getDato() + "---" + getPeso() + "---" + fin.getDato() + "]";
    }
}