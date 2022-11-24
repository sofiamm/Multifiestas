package multifiesta;

public class Nodo {
    
    private Clientes elemento;
    private Nodo siguiente;

    public Nodo() {
        this.siguiente = null;
    }

    public Clientes getElemento() {
        return elemento;
    }

    public void setElemento(Clientes elemento) {
        this.elemento = elemento;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
