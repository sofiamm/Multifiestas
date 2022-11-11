package multifiestas;

import javax.swing.JOptionPane;

public class Menu {
    private int opcion;
    Lista lsc = new Lista();

    public void mostrarMenu() {
        JOptionPane.showMessageDialog(null,"Bienvenid@ al sistema de compra del grupo Multifiestas");
        
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
                 JOptionPane.showMessageDialog(null, "Metodo en construcción" );
                mostrarMenu();
                break;
            }
            case 4: {
                JOptionPane.showMessageDialog(null, "Gracias por usar el sistema del grupo Multifiestas  :)" );
                System.exit(0);
                break;
            }
            default: {
                JOptionPane.showMessageDialog(null,
                        "¡Opción invalida, ingrese una de las opciones validas del menu!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
