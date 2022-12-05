package multifiesta;

public class NodoLC {
    private Eventos_Datos dato;
    private NodoLC siguiente;

    public NodoLC(){
        this.siguiente=null;
    }

    public NodoLC getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLC siguiente) {
        this.siguiente = siguiente;
    }


    public Eventos_Datos getDato() {
        return dato;
    }


    public void setDato(Eventos_Datos dato) {
        this.dato = dato;
    }
}
