package multifiesta;

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
                "Digite su nombre completo para registrarlo en el sistema: "));
        e.setUsername(JOptionPane.showInputDialog(null,
                "Digite su Username: "));
        e.setPassword(JOptionPane.showInputDialog(null,
                "Digite su contraseña: "));

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
            s = s + aux.getElemento().getNombre() + " - " + aux.getElemento().getUsername() + " - "
                    + aux.getElemento().getPassword() + " - " + aux.getElemento().getEstado() + "\n";
            aux = aux.getSiguiente();
            while (aux != inicio) {
                s = s + aux.getElemento().getNombre() + " - " + aux.getElemento().getUsername() + " - "
                        + aux.getElemento().getPassword() + " - " + aux.getElemento().getEstado() + "\n";
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "La lista de clientes registrados es:\n" + s);
        } else {
            JOptionPane.showMessageDialog(null, "¡No se puede mostrar el registro, lista de clientes vacía!",
                    "Lista vacía", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void inactivar_usuario() {
        if (!esVacia()) {

            String nom = (JOptionPane.showInputDialog(null, "Digite el Username de la persona a inactivar: "));

            String s = "";
            Nodo aux = inicio;
            if (aux.getElemento().getUsername().equals(nom)) {
                inicio.getElemento().setEstado(inicio.getElemento().getInac());
            }
            aux = aux.getSiguiente();

            while (aux != inicio) {
                if (aux.getElemento().getUsername().equals(nom)) {
                    inicio.getElemento().setEstado(inicio.getElemento().getInac());
                }
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "El estado del usuario: " + inicio.getElemento().getUsername() + " es " + inicio.getElemento().getInac());

        } else {
            JOptionPane.showMessageDialog(null, "No se puede mostrar, lista vacía!", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void login() {
        if (!esVacia()) {

            String nom = (JOptionPane.showInputDialog(null, "Ingrese su Username: "));
            String contra = (JOptionPane.showInputDialog(null, "Ingrese su contraseña:"));

            String s = "";
            Nodo aux = inicio;
            if (aux.getElemento().getUsername().equals(nom) && aux.getElemento().getPassword().equals(contra)) {
                Menu m = new Menu();
                m.mostrarMenuL();

                JOptionPane.showMessageDialog(null, "Bienvenido a Multifiesta");
            } else {

                JOptionPane.showMessageDialog(null, "No se puede mostrar, lista vacía!", "Error",
                        JOptionPane.ERROR_MESSAGE);
                Menu m = new Menu();
                m.mostrarMenuR();
            }
        }
    }
}
