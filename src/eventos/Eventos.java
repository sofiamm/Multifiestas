package eventos;

import clientes.Lista;
import ventas.MenuVentas;
import javax.swing.JOptionPane;
import clientes.Menu;

public class Eventos extends Lista {

    private NodoDC inicio;
    private NodoDC fin;
    private NodoLC inicioEvento;
    private NodoLC finEvento;

    public Eventos() {
        this.inicio = null;
        this.fin = null;
        this.inicioEvento = null;
        this.finEvento = null;
    }

    public boolean esVaciaEvento() {
        if (inicioEvento == null) {
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

    public void Menu() {
        Menu m = new Menu();
        MenuVentas mv = new MenuVentas();
        int opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "-- MENÚ EVENTOS --\n\n"
                + "1. Agregar evento\n"
                + "2. Editar catálogo de eventos\n"
                + "3. Editar catálogo de asientos\n"
                + "4. Invalidar\n"
                + "5. Mostrar catálogos\n"
                + "6. Comprar asientos\n"
                + "7. Volver a menú principal\n\n"
                + "Digite su opción:"));

        switch (opcion) {
            case 1: {
                CatalogoEventos();
                CatalogoAsientos();
                Menu();
                break;
            }
            case 2: {
                editarEvento();
                Menu();
                break;
            }
            case 3: {
                editarAsiento();
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
                mostrarEventos();
                mostrarAsientos();
                Menu();
                break;
            }
            case 6: {
                mv.mostrarMenu();
                Menu();
                break;
            }
            case 7: {
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
        e.setFechaEve(JOptionPane.showInputDialog(null,
                "Ingrese la fecha:"));
        e.setLugarEve(JOptionPane.showInputDialog(null,
                "Ingrese el lugar:"));
        e.setCiudad(JOptionPane.showInputDialog(null,
                "Ingrese la ciudad:"));
        e.setDireccionEve(JOptionPane.showInputDialog(null,
                "Ingrese la dirección:"));

        NodoLC nuevo = new NodoLC();
        nuevo.setDato(e);
        if (esVaciaEvento()) {
            inicioEvento = nuevo;
            finEvento = nuevo;
            finEvento.setSiguiente(inicioEvento);
        } else if (e.getNombreEve().compareTo(inicioEvento.getDato().getNombreEve()) < 0) {
            nuevo.setSiguiente(inicioEvento);
            inicioEvento = nuevo;
            finEvento.setSiguiente(inicioEvento);
        } else if (e.getNombreEve().compareTo(finEvento.getDato().getNombreEve()) >= 0) {
            finEvento.setSiguiente(nuevo);
            finEvento = nuevo;
            finEvento.setSiguiente(inicioEvento);
        } else {
            NodoLC aux = inicioEvento;
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
            NodoLC aux = inicioEvento;
            String evento = (JOptionPane.
                    showInputDialog(null, "Digite el nombre del evento que desea cambiar:"));
            if (aux.getDato().getNombreEve().equals(evento)) {
                String nuevo = (JOptionPane.
                        showInputDialog(null, "Digite el nuevo nombre del evento:"));
                inicioEvento.getDato().setNombreEve(nuevo);

            }
            aux = aux.getSiguiente();

            while (aux != inicioEvento) {
                if (aux.getDato().getNombreEve().equals(evento)) {
                    String nuevo = (JOptionPane.
                            showInputDialog(null, "Digite el nuevo nombre del evento:"));
                    inicioEvento.getDato().setNombreEve(nuevo);

                }
                aux = aux.getSiguiente();
            }
            if (aux.getDato().getNombreEve().equals(evento)) {
                JOptionPane.showMessageDialog(null, "¡Evento editado correctamente!",
                        "Succesful", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "¡Evento no editado!",
                        "Error", JOptionPane.INFORMATION_MESSAGE);

            }

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
            NodoLC aux = inicioEvento;
            s = s + "Nombre del evento: " + aux.getDato().getNombreEve() + "\n"
                    + "Fecha del evento: " + aux.getDato().getFechaEve() + "\n"
                    + "Lugar del evento: " + aux.getDato().getLugarEve() + "\n"
                    + "Dirección del evento: " + aux.getDato().getDireccionEve() + "\n"
                    + "Ciudad del evento: " + aux.getDato().getCiudad();
            aux = aux.getSiguiente();
            while (aux != inicioEvento) {
                s = s + aux.getDato().getNombreEve() + " - " + aux.getDato().getFechaEve() + " - "
                        + aux.getDato().getLugarEve() + " - " + aux.getDato().getDireccionEve() + "\n";
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "Catálago de eventos\n" + s);
        } else {
            JOptionPane.showMessageDialog(null, "¡No se puede mostrar la lista vacía!",
                    "Lista vacía", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void mostrarAsientos() {
        if (!esVaciaAsiento()) {
            String s = "";
            NodoDC aux = inicio;
            s = s + "Numero de asiento: " + aux.getDato().getNumeroA() + "\n"
                    + "Codigo de area: " + aux.getDato().getCodigoArea() + "\n"
                    + "Costo del evento: " + aux.getDato().getCosto() + "\n";
            aux = aux.getSiguiente();
            while (aux != inicio) {
                s = s + aux.getDato().getNumeroA() + " - " + aux.getDato().getCodigoArea() + " - "
                        + aux.getDato().getCosto() + "\n";
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "Catálogo de asientos\n" + s);
        } else {
            JOptionPane.showMessageDialog(null, "¡No se puede mostrar la lista vacía!",
                    "Lista vacía", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void inactivarEvento() {
        if (!esVaciaEvento()) {
            String evento = JOptionPane.showInputDialog(null, "Ingrese el evento a invalidar");
            NodoLC aux = inicioEvento;
            if (aux.getDato().getNombreEve().equals(evento)) {
                inicioEvento.getDato().setEstadoEve(inicioEvento.getDato().getEstadoEve2());
            }
            aux = aux.getSiguiente();

            while (aux != inicioEvento) {
                if (aux.getDato().getNombreEve().equals(evento)) {
                    inicioEvento.getDato().setEstadoEve(inicioEvento.getDato().getEstadoEve2());
                }
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "El estado del usuario: " + inicioEvento.getDato().getNombreEve() + " es " + inicioEvento.getDato().getEstadoEve2());

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
