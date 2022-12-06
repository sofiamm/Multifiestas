package eventos;

public class NodoDC {

    private Datos dato;
    private NodoDC siguiente;
    private NodoDC anterior;

    public NodoDC() {
        this.siguiente = null;
        this.anterior = null;
    }

    public NodoDC getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDC siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDC getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDC anterior) {
        this.anterior = anterior;
    }

    public Datos getDato() {
        return dato;
    }

    public void setDato(Datos dato) {
        this.dato = dato;
    }

}
