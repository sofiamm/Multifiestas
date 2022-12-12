package ventas;

import javax.swing.JOptionPane;



public class Arbol {

    private NodoA raiz;
    private NodoDC inicio;
    private NodoDC fin;
    private int Tam;
    public Arbol() {
        this.raiz = null;
        this.inicio=null;
        this.fin=null;
        this.Tam=0;
    }

    public boolean esVacio() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }
    }
    public boolean esVacioDC() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void inserta() {
        int num = Integer.parseInt(JOptionPane.showInputDialog(null,
                "¿Cuántos asientos desea comprar?"));
        while (num != 0) {
            Dato d = new Dato();
            d.setNumeroAsiento(Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Digite el número de asiento:")));
            num = num - 1;
            NodoA nuevo = new NodoA();
            nuevo.setElemento(d);
            if (esVacio()) {
                raiz = nuevo;
            } else {
                insertarNuevo(raiz, nuevo);
            }
        }
    }

    public void insertarNuevo(NodoA raiz, NodoA nuevo) {
        if (nuevo.getElemento().getNumeroAsiento() <= raiz.getElemento().getNumeroAsiento()) {
            if (raiz.getEnlaceIzq() == null) {
                raiz.setEnlaceIzq(nuevo);
            } else {
                insertarNuevo(raiz.getEnlaceIzq(), nuevo);
            }
        } else {
            if (raiz.getEnlaceDer() == null) {
                raiz.setEnlaceDer(nuevo);
            } else {
                insertarNuevo(raiz.getEnlaceDer(), nuevo);
            }
        }
    }

    public void modificarAsiento() {
        if (!esVacio()) {
            int asiento = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Digite el número de asiento que quiere modificar:"));
            if (asiento == raiz.getElemento().getNumeroAsiento()) {
                raiz.getElemento().setNumeroAsiento(Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Digite el nuevo número de asiento:")));
            } else if (raiz.getEnlaceDer() != null && asiento == raiz.getEnlaceDer().getElemento().getNumeroAsiento()) {
                raiz.getEnlaceDer().getElemento().setNumeroAsiento(Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Digite el nuevo número de asiento:")));
            } else if (raiz.getEnlaceIzq() != null && asiento == raiz.getEnlaceIzq().getElemento().getNumeroAsiento()) {
                raiz.getEnlaceIzq().getElemento().setNumeroAsiento(Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Digite el nuevo número de asiento:")));
            }
        } else {
            JOptionPane.showMessageDialog(null, "¡No se puede mostrar, árbol vacío!");
        }
    }

    public void cancelarAsiento() {
        if (!esVacio()) {
            int asiento = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Digite el número de asiento que quiere cancelar:"));
            if (asiento == raiz.getElemento().getNumeroAsiento()) {
                raiz.getElemento().setEstadoAsiento(raiz.getElemento().getEstadoAsiento2());
                raiz.getElemento().setNumeroAsiento(0);
            } else if (raiz.getEnlaceDer() != null && asiento == raiz.getEnlaceDer().getElemento().getNumeroAsiento()) {
                raiz.getEnlaceDer().getElemento().setEstadoAsiento(raiz.getEnlaceDer().getElemento().getEstadoAsiento2());
                raiz.getEnlaceDer().getElemento().setNumeroAsiento(0);
            } else if (raiz.getEnlaceIzq() != null && asiento == raiz.getEnlaceIzq().getElemento().getNumeroAsiento()) {
                raiz.getEnlaceIzq().getElemento().setEstadoAsiento(raiz.getEnlaceIzq().getElemento().getEstadoAsiento2());
                raiz.getEnlaceIzq().getElemento().setNumeroAsiento(0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "¡No se puede mostrar, árbol vacío!");
        }
    }

    public void mostrarRaiz() {
        if (!esVacio()) {
            mostrarNodo(raiz);
        } else {
            JOptionPane.showMessageDialog(null, "¡No se puede mostrar, árbol vacío!");
        }
    }

    public void mostrarNodo(NodoA raiz) {
        if (raiz != null) {
            mostrarNodo(raiz.getEnlaceIzq());           
            System.out.print(" " + raiz.getElemento().getNumeroAsiento() + " " + raiz.getElemento().getNombre() + " " + raiz.getElemento().getDateTime() + " " + raiz.getElemento().getNombreEve() + " ");
            mostrarNodo(raiz.getEnlaceDer());
        }
        System.out.print("\n");
    }
    public void Ingresos_del_Dia() {
        Dato e = new Dato();
        e.setCosto(Double.parseDouble(JOptionPane.showInputDialog(null, "Digite el Costo")));
        NodoDC nuevo = new NodoDC();
        nuevo.setDato(e);
        if (esVacioDC()) {
            inicio = nuevo;
            fin = nuevo;
            fin.setSiguiente(inicio);
            inicio.setAnterior(fin);
        } else if (e.getCosto() < inicio.getDato().getCosto()) {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
            fin.setSiguiente(inicio);
            inicio.setAnterior(fin);
        } else if (e.getCosto() >= fin.getDato().getCosto()) {
            fin.setSiguiente(nuevo);
            fin = nuevo;
            fin.setSiguiente(inicio);
            inicio.setAnterior(fin);
        } else {
            NodoDC aux = inicio;
            while (aux.getSiguiente().getDato().getCosto() < e.getCosto()) {
                aux = aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            nuevo.setAnterior(aux);
            aux.setSiguiente(nuevo);
            nuevo.getSiguiente().setAnterior(nuevo);
        }
      ++Tam;
    }
    
    public void Suma(){
        if(!esVacioDC()){
            double total=0;
            String s="";
            int num = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "¿Cuántos asientos compro?"));
        NodoDC aux= inicio;
       total= num*inicio.getDato().getCosto();
       s=s+"El monto total"+total;
      aux=aux.getSiguiente();
      
      while(aux!=inicio){
        total= num*inicio.getDato().getCosto();
        s=s+"El monto total"+total;
       aux=aux.getSiguiente();
       
   }
   JOptionPane.showMessageDialog(null,"Montos totales\n"+s);
    }
}

    public void mostrarAlmacenaje() {
        if (!esVacioDC()) {
            String s = "";
            NodoDC aux = inicio;
            s =s +  "Ingresos del dia\n"+Tam+"\n"+inicio.getDato().getDateTime();
            aux = aux.getSiguiente();
            while (aux != inicio) {
                s = s+ "Ingresos del dia\n"+Tam+"\n"+inicio.getDato().getDateTime();
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "Catálogo de asientos\n" + s);
        } else {
            JOptionPane.showMessageDialog(null, "¡No se puede mostrar la lista vacía!",
                    "Lista vacía", JOptionPane.ERROR_MESSAGE);
        }
    }

}
