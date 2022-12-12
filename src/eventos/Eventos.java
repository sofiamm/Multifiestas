package eventos;

import clientes.Lista;
import clientes.Menu;
import javax.swing.JOptionPane;

public class Eventos extends Lista {

    private NodoDC inicio;
    private NodoDC fin;
    private NodoLC inicio2;
    private NodoLC fin2;

    public Eventos() {
        this.inicio = null;
        this.fin = null;
        this.inicio2 = null;
        this.fin2 = null;
    }

    public boolean esVaciaLC() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean esVaciaDC() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void Menu() {
        Menu m = new Menu();
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "-- MENÚ EVENTOS --\n\n"
                + "1. Agregar evento\n"
                + "2. Editar catálogo de eventos\n"
                + "3. Editar catálogo de asientos\n"
                + "4. Invalidar\n"
                + "5. Mostrar eventos y asientos\n"
                + "6. Volver a menú principal\n\n"
                + "Digite su opción:"));

        switch (opcion) {
            case 1: {
                CatalogoEventos();
                CatalogoAsientos();
                Menu();
                break;
            }
            case 2: {
                editar();
                Menu();
                break;
            }
            case 3: {
                editar2();
                Menu();
                break;
            }
            case 4: {
                int op = Integer.parseInt(JOptionPane.showInputDialog(null, "-- MENÚ INVALIDAR --\n\n"
                        + "1. Invalidar eventos\n"
                        + "2. Invalidar asientos \n"
                        + "3. para salir\n\n"
                        + "Digite su opción:"));
                switch (op) {
                    case 1: {
                        inactivarEvento();
                        break;
                    }
                    case 2: {
                        inactivarAsiento();
                        break;
                    }
                    case 3: {
                        Menu();
                    }
                    default: {
                        JOptionPane.showMessageDialog(null,
                                "¡Opción invalida, ingrese una de las opciones validas del menu!", "Error", JOptionPane.ERROR_MESSAGE);
                        Menu();
                    }
                }
            }
            case 5: {
                mostrarLC();
                mostrarDC();
                Menu();
                break;
            }
            case 6: {
                m.mostrarMenu();
                Menu();
                break;
            }
            default: {
                JOptionPane.showMessageDialog(null,
                        "¡Opción invalida, ingrese una de las opciones validas del menu!", "Error", JOptionPane.ERROR_MESSAGE);
                Menu();
            }

        }
    }

    public void CatalogoEventos() {
        Datos e = new Datos();
        e.setNombreEve(JOptionPane.showInputDialog(null,
                "Ingrese el nombre del evento:"));
        e.setFechaEveEve(JOptionPane.showInputDialog(null,
                "Ingrese la fecha:"));
        e.setLugarEveEve(JOptionPane.showInputDialog(null,
                "Ingrese el lugar:"));
        e.setDireccionEve(JOptionPane.showInputDialog(null,
                "Ingrese la dirección con la ciudad:"));
        
        NodoLC nuevo = new NodoLC();
        nuevo.setDato(e);
        if (esVaciaLC()) {
            inicio2 = nuevo;
            fin2 = nuevo;
            fin2.setSiguiente(inicio2);
        } else if (e.getNombreEve().compareTo(inicio2.getDato().getNombreEve()) < 0) {
            nuevo.setSiguiente(inicio2);
            inicio2 = nuevo;
            fin2.setSiguiente(inicio2);
        } else if (e.getNombreEve().compareTo(fin.getDato().getNombreEve()) >= 0) {
            fin2.setSiguiente(nuevo);
            fin2 = nuevo;
            fin2.setSiguiente(inicio2);
        } else {
            NodoLC aux = inicio2;
            while (aux.getSiguiente().getDato().getNombreEve().compareTo(e.getNombreEve()) < 0) {
                aux = aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);
        }
    }

    public void CatalogoAsientos() {
        Datos e = new Datos();
        e.setCodigoArea(Long.parseLong(JOptionPane.showInputDialog(null,
                "Ingrese el código de área:")));
        e.setNumeroA(Integer.parseInt(JOptionPane.showInputDialog(null,
                "Ingrese el número de asiento:")));
        e.setCosto(Double.parseDouble(JOptionPane.showInputDialog(null,
                "Ingrese el costo de venta:")));
        NodoDC nuevo = new NodoDC();
        nuevo.setDato(e);
        if (esVaciaDC()) {
            inicio = nuevo;
            fin = nuevo;
            fin.setSiguiente(inicio);
            inicio.setAnterior(fin);
        } else if (e.getNumeroA() < inicio.getDato().getNumeroA()) {
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
            fin.setSiguiente(inicio);
            inicio.setAnterior(fin);
        } else if (e.getNumeroA() >= fin.getDato().getNumeroA()) {
            fin.setSiguiente(nuevo);
            fin = nuevo;
            fin.setSiguiente(inicio);
            inicio.setAnterior(fin);
        } else {
            NodoDC aux = inicio;
            while (aux.getSiguiente().getDato().getNumeroA() < e.getNumeroA()) {
                aux = aux.getSiguiente();
            }
            nuevo.setSiguiente(aux.getSiguiente());
            nuevo.setAnterior(aux);
            aux.setSiguiente(nuevo);
            nuevo.getSiguiente().setAnterior(nuevo);
        }
    }

    public void editar() {
        if (!esVaciaLC()) {
            NodoLC aux = inicio2;
            String evento = (JOptionPane.
                    showInputDialog(null, "Digite el nombre del evento"));
            if (aux.getDato().getNombreEve().equals(evento)) {
                String nuevo = (JOptionPane.
                        showInputDialog(null, "Coloque el nuevo dato a editar"));
                inicio2.getDato().setNombreEve(nuevo);

            }
            aux = aux.getSiguiente();

            while (aux != inicio2) {
                if (aux.getDato().getNombreEve().equals(evento)) {
                    String nuevo = (JOptionPane.
                            showInputDialog(null, "Coloque el nuevo dato a editar"));
                    inicio2.getDato().setNombreEve(nuevo);

                }
                aux = aux.getSiguiente();
            }
            JOptionPane.
                    showMessageDialog(null, "Dato editado correctamente",
                            "successful", JOptionPane.INFORMATION_MESSAGE);

        }

    }

    public void editar2() {
        if (!esVaciaDC()) {
            NodoDC aux = inicio;
            int asiento = (Integer.parseInt(JOptionPane.
                    showInputDialog(null, "Digite el número de asiento:")));
            if (aux.getDato().getNumeroA() == asiento) {
                int nuevoA = (Integer.parseInt(JOptionPane.
                        showInputDialog(null, "Coloque el nuevo número de asiento:")));
                        //Estado del asiento-disponibilidad del mismo
                inicio.getDato().setNumeroA(nuevoA);
            }
            aux = aux.getSiguiente();
            while (aux != inicio) {
                if (aux.getDato().getNumeroA() == asiento) {
                    int nuevoA = (Integer.parseInt(JOptionPane.
                            showInputDialog(null, "Coloque el nuevo dato a editar")));
                    inicio.getDato().setNumeroA(nuevoA);
                }
            }
            aux = aux.getSiguiente();
        }
        JOptionPane.
                showMessageDialog(null, "Dato editado correctamente",
                        "successful", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarLC() {
        if (!esVaciaLC()) {
            String s = "";
            NodoLC aux = inicio2;
            s = s + aux.getDato().getNombreEve() + " - " + aux.getDato().getFechaEve() + " - "
                    + aux.getDato().getLugarEve() + " - " + aux.getDato().getDireccionEve() + "\n";
            aux = aux.getSiguiente();
            while (aux != inicio2) {
                s = s + aux.getDato().getNombreEve() + " - " + aux.getDato().getFechaEve() + " - "
                        + aux.getDato().getLugarEve() + " - " + aux.getDato().getDireccionEve() + "\n";
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "La lista de Catalago de eventos contiene:\n" + s);
        } else {
            JOptionPane.showMessageDialog(null, "¡No se puede mostrar, lista vacía!",
                    "Lista vacía", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void mostrarDC() {
        if (!esVaciaDC()) {
            String s = "";
            NodoDC aux = inicio;
            s = s + aux.getDato().getNumeroA() + " - " + aux.getDato().getCodigoArea() + " - "
                    + aux.getDato().getCosto() + "\n";
            aux = aux.getSiguiente();
            while (aux != inicio) {
                s = s + aux.getDato().getNumeroA() + " - " + aux.getDato().getCodigoArea() + " - "
                        + aux.getDato().getCosto() + "\n";
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "La lista de Catalogo de asientos contiene:\n" + s);
        } else {
            JOptionPane.showMessageDialog(null, "¡No se puede mostrar, lista vacía!",
                    "Lista vacía", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void inactivarEvento() {
        if (!esVaciaLC()) {
            String evento = JOptionPane.showInputDialog(null, "Ingrese el evento a invalidar");
            NodoLC aux = inicio2;
            if (aux.getDato().getNombreEve().equals(evento)) {
                inicio2.getDato().setEstado(inicio2.getDato().getEstado2());
            }
            aux = aux.getSiguiente();

            while (aux != inicio2) {
                if (aux.getDato().getNombreEve().equals(evento)) {
                    inicio2.getDato().setEstado(inicio2.getDato().getEstado2());
                }
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "El estado del usuario: " + inicio2.getDato().getNombreEve() + " es " + inicio2.getDato().getEstado2());

        } else {
            JOptionPane.showMessageDialog(null, "No se puede mostrar, lista vacía!", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void inactivarAsiento() {
        if (!esVaciaDC()) {
            int asiento = (Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el asiento a invalidar")));
            String s = "";
            NodoDC aux = inicio;
            if (aux.getDato().getNumeroA() == asiento) {
                inicio.getDato().setEstado(inicio.getDato().getEstado2());
            }
            aux = aux.getSiguiente();

            while (aux != inicio) {
                if (aux.getDato().getNumeroA() == asiento) {
                    inicio.getDato().setEstado(inicio.getDato().getEstado2());
                }
                aux = aux.getSiguiente();

            }
            JOptionPane.showMessageDialog(null, "El estado del usuario: " + inicio.getDato().getNumeroA() + " es " + inicio.getDato().getEstado2());

        } else {
            JOptionPane.showMessageDialog(null, "No se puede mostrar, lista vacía!", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
