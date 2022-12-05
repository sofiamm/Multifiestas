package multifiesta;

public class NodoDC {
    private Eventos_Datos dato;
    private NodoDC siguiente;
    private NodoDC anterior;

    public NodoDC(){
        this.siguiente=null;
        this.anterior=null;
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


    public Eventos_Datos getDato() {
        return dato;
    }

    public void setDato(Eventos_Datos dato) {
        this.dato = dato;
    }

}
