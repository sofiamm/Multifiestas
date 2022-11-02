package multifiestas;

import javax.swing.JOptionPane;

public class Menu {
    private int opcion;
    Lista lsc = new Lista();

    public void mostrarMenu() {
        opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "-- MENÚ PRINCIPAL --\n\n"
                + "1. Agregar estudiante\n"
                + "2. Mostrar estudiantes por nombre\n"
                + "3. Mostrar estudiantes por notas\n"
                + "4. Salir del sistema\n\n"
                + "Digite su opción:"));
        switch (opcion) {
            case 1: {
                lsc.agregar();
                mostrarMenu();
                break;
            }
            case 2: {
                lsc.mostrarPorNombre();
                mostrarMenu();
                break;
            }
            case 3: {
                lsc.mostrarNotaMayorMenor();
                mostrarMenu();
                break;
            }
            case 4: {
                System.exit(0);
                break;
            }
            default: {
                JOptionPane.showMessageDialog(null,
                        "¡Opción incorrecta!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
