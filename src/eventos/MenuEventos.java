package eventos;

import clientes.Menu;
import javax.swing.JOptionPane;

public class MenuEventos {

    private int opcion;

    public void Menu() {
        Menu m = new Menu();
        Eventos eve = new Eventos();

        opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "-- MENÚ EVENTOS --\n\n"
                + "1. Agregar evento\n"
                + "2. Editar catálogo de eventos\n"
                + "3. Editar catálogo de asientos\n"
                + "4. Invalidar\n"
                + "5. Mostrar eventos y asientos\n" //COMPRAR ASIENTOS
                + "6. Volver a menú principal\n\n"
                + "Digite su opción:"));
        switch (opcion) {
            case 1: {
                eve.CatalogoEventos();
                eve.CatalogoAsientos();
                Menu();
                break;
            }
            case 2: {
                eve.editar();
                Menu();
                break;
            }
            case 3: {
                eve.editar2();
                Menu();
                break;
            }
            case 4: {
                int op = Integer.parseInt(JOptionPane.showInputDialog(null, "-- MENÚ INVALIDAR --\n\n"
                        + "1. Invalidar eventos\n"
                        + "2. Invalidar asientos \n"
                        + "3. Volver a menú eventos\n\n"
                        + "Digite su opción:"));
                switch (op) {
                    case 1: {
                        eve.inactivarEvento();
                        break;
                    }
                    case 2: {
                        eve.inactivarAsiento();
                        break;
                    }
                    case 3: {
                        Menu();
                    }
                    default: {
                        JOptionPane.showMessageDialog(null,
                                "¡Opción invalida, ingrese una de las opciones válidas del menú!", "Error", JOptionPane.ERROR_MESSAGE);
                        Menu();
                    }
                }
            }
            case 5: {
                eve.mostrarLC();
                eve.mostrarDC();
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
                        "¡Opción invalida, ingrese una de las opciones válidas del menú!", "Error", JOptionPane.ERROR_MESSAGE);
                Menu();
            }

        }
    }
}
