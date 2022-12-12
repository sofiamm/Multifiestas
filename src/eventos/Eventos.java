package eventos;

import clientes.Lista;
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

    public boolean esVaciaEvento() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean esVaciaAsiento() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void CatalogoEventos() {
        Datos e = new Datos();
        e.setNombreEve(JOptionPane.showInputDialog(null,
                "Ingrese el nombre del evento:"));
        e.setFechaEve(JOptionPane.showInputDialog(null,
                "Ingrese la fecha:"));
        e.setLugarEve(JOptionPane.showInputDialog(null,
                "Ingrese el lugar:"));
        e.setDireccionEve(JOptionPane.showInputDialog(null,
                "Ingrese la ciudad:"));
        e.setDireccionEve(JOptionPane.showInputDialog(null,
                "Ingrese la dirección:"));

        NodoLC nuevo = new NodoLC();
        nuevo.setDato(e);
        if (esVaciaEvento()) {
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
        if (esVaciaAsiento()) {
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

    public void editarEvento() {
        if (!esVaciaEvento()) {
            NodoLC aux = inicio2;
            String evento = (JOptionPane.
                    showInputDialog(null, "Digite el nombre del evento que desea cambiar:"));
            if (aux.getDato().getNombreEve().equals(evento)) {
                String nuevo = (JOptionPane.
                        showInputDialog(null, "Digite el nuevo nombre del evento:"));
                inicio2.getDato().setNombreEve(nuevo);

            }
            aux = aux.getSiguiente();

            while (aux != inicio2) {
                if (aux.getDato().getNombreEve().equals(evento)) {
                    String nuevo = (JOptionPane.
                            showInputDialog(null, "Digite el nuevo nombre del evento:"));
                    inicio2.getDato().setNombreEve(nuevo);

                }
                aux = aux.getSiguiente();
            }
            JOptionPane.
                    showMessageDialog(null, "¡Evento editado correctamente!",
                            "successful", JOptionPane.INFORMATION_MESSAGE);

        }

    }

    public void editarAsiento() {
        if (!esVaciaAsiento()) {
            NodoDC aux = inicio;
            int asiento = (Integer.parseInt(JOptionPane.
                    showInputDialog(null, "Digite el número de asiento a editar:")));
            if (aux.getDato().getNumeroA() == asiento) {
                int nuevoA = (Integer.parseInt(JOptionPane.
                        showInputDialog(null, "Digite el nuevo número de asiento:")));
                //Estado del asiento-disponibilidad del mismo
                inicio.getDato().setNumeroA(nuevoA);
            }
            aux = aux.getSiguiente();
            while (aux != inicio) {
                if (aux.getDato().getNumeroA() == asiento) {
                    int nuevoA = (Integer.parseInt(JOptionPane.
                            showInputDialog(null, "Digite el nuevo número de asiento:")));
                    inicio.getDato().setNumeroA(nuevoA);
                }
            }
            aux = aux.getSiguiente();
        }
        JOptionPane.
                showMessageDialog(null, "¡Asiento editado correctamente!",
                        "successful", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarEventos() {
        if (!esVaciaEvento()) {
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
            JOptionPane.showMessageDialog(null, "Catálago de eventos:\n" + s);
        } else {
            JOptionPane.showMessageDialog(null, "¡No se puede mostrar la lista vacía!",
                    "Lista vacía", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void mostrarAsientos() {
        if (!esVaciaAsiento()) {
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
            JOptionPane.showMessageDialog(null, "Catálogo de asientos:\n" + s);
        } else {
            JOptionPane.showMessageDialog(null, "¡No se puede mostrar la lista vacía!",
                    "Lista vacía", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void inactivarEvento() {
        if (!esVaciaEvento()) {
            String evento = JOptionPane.showInputDialog(null, "Ingrese el evento a invalidar");
            NodoLC aux = inicio2;
            if (aux.getDato().getNombreEve().equals(evento)) {
                inicio2.getDato().setEstadoEve(inicio2.getDato().getEstadoEve2());
            }
            aux = aux.getSiguiente();

            while (aux != inicio2) {
                if (aux.getDato().getNombreEve().equals(evento)) {
                    inicio2.getDato().setEstadoEve(inicio2.getDato().getEstadoEve2());
                }
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "El estado del usuario: " + inicio2.getDato().getNombreEve() + " es " + inicio2.getDato().getEstadoEve2());

        } else {
            JOptionPane.showMessageDialog(null, "No se puede mostrar, lista vacía!", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void inactivarAsiento() {
        if (!esVaciaAsiento()) {
            int asiento = (Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el asiento a liberar")));
            NodoDC aux = inicio;
            if (aux.getDato().getNumeroA() == asiento) {
                inicio.getDato().setEstadoAsiento(inicio.getDato().getEstadoAsiento2());
            }
            aux = aux.getSiguiente();

            while (aux != inicio) {
                if (aux.getDato().getNumeroA() == asiento) {
                    inicio.getDato().setEstadoAsiento(inicio.getDato().getEstadoAsiento2());
                }
                aux = aux.getSiguiente();

            }
            JOptionPane.showMessageDialog(null, "El asiento: " + inicio.getDato().getNumeroA() + " esta " + inicio.getDato().getEstadoAsiento2());

        } else {
            JOptionPane.showMessageDialog(null, "¡No se puede mostrar la lista vacía!", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
