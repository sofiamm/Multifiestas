package eventos;

public class NodoLC {

    private Datos dato;
    private NodoLC siguiente;

    public NodoLC() {
        this.siguiente = null;
    }

    public NodoLC getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLC siguiente) {
        this.siguiente = siguiente;
    }

    public Datos getDato() {
        return dato;
    }

    public void setDato(Datos dato) {
        this.dato = dato;
    }
}
