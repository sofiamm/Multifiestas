package multifiestas;

import javax.swing.JOptionPane;

public class Lista {
    private Nodo inicio;
    private Nodo fin;

    public Lista() {
        this.inicio = null;
        this.fin = null;
    }

    public boolean esVacia() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void agregar() {
        Clientes e = new Clientes();
        e.setNombre(JOptionPane.showInputDialog(null,
                "Digite el id del estudiante:"));
        e.setNombre(JOptionPane.showInputDialog(null,
                "Digite el nombre del estudiante:"));
        e.setNotaPromedio(Integer.parseInt(JOptionPane.showInputDialog(null,
                "Digite el promedio:")));
        e.setEstado(JOptionPane.showInputDialog(null,
                "Digite el estado:"));
        Nodo nuevo = new Nodo();
        nuevo.setElemento(e);
        if (esVacia()) {
            inicio = nuevo;
            fin = nuevo;
            fin.setSiguiente(inicio);
        } else if (e.getNombre().compareTo(inicio.getElemento().getNombre()) < 0) {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
            fin.setSiguiente(inicio);
        } else if (e.getNombre().compareTo(fin.getElemento().getNombre()) >= 0) {
            fin.setSiguiente(nuevo);
            fin = nuevo;//fin=fin.getSiguiente();
            fin.setSiguiente(inicio);
        } else {
            Nodo aux = inicio;
            while (aux.getSiguiente().getElemento().getNombre().compareTo(e.getNombre()) < 0) {
                aux = aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
        }
    }

    public void mostrarPorNombre() {
        if (!esVacia()) {
            String s = "";
            Nodo aux = inicio;
            s = s + aux.getElemento().getNombre() + " - " + aux.getElemento().getId() + " - "
                    + aux.getElemento().getNotaPromedio() + " - " + aux.getElemento().getEstado() + "\n";
            aux = aux.getSiguiente();
            while (aux != inicio) {
                s = s + aux.getElemento().getNombre() + " - " + aux.getElemento().getId() + " - "
                        + aux.getElemento().getNotaPromedio() + " - " + aux.getElemento().getEstado() + "\n";
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "La lista de estudiantes es:\n" + s);
        } else {
            JOptionPane.showMessageDialog(null, "¡No se puede mostrar, lista vacía!",
                    "Lista vacía", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void mostrarNotaMayorMenor() {
        int mayor = 0;
        int menor = 0;

        Nodo aux = inicio;
        if (!esVacia()) {
            mayor = aux.getElemento().getNotaPromedio();
            menor = aux.getElemento().getNotaPromedio();
            aux = aux.getSiguiente();
            while (aux != inicio) {
                if (aux.getElemento().getNotaPromedio() > mayor) {
                    mayor = aux.getElemento().getNotaPromedio();
                }
                if (aux.getElemento().getNotaPromedio() < menor) {
                    menor = aux.getElemento().getNotaPromedio();
                }
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "La nota mayor es:\n" + mayor + "La nota mayor es:\n" + menor);
        } else {
            JOptionPane.showMessageDialog(null, "¡No se puede mostrar!",
                    "Lista vacía", JOptionPane.ERROR_MESSAGE);
        }
    }
}
