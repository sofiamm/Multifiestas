package multifiesta;

import javax.swing.JOptionPane;

public class Menu {

    private int opcion;
    Lista lsc = new Lista();
    
    public void mostrarMenu() {
        opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "-- MENÚ PRINCIPAL --\n\n"  
                + "1. Registrarme\n"
                + "2. Iniciar Sesión\n"
                + "3. Mostrar clientes por nombre\n"
                + "4. Inactivar Usuario\n"
                + "5. Mostrar Catalogo de eventos\n"
                + "6. Salir del sistema\n\n"
                + "Digite su opción:"));
        
        switch (opcion) {
            case 1: {
                lsc.agregar();
                mostrarMenu();
                break;
            }
            case 2: {
                lsc.login();
                mostrarMenu();
                break;
            }
            case 3: {
                lsc.mostrarPorNombre();
                mostrarMenu();
                break;
            }
            case 4: {
                lsc.inactivar_usuario();
                JOptionPane.showMessageDialog(null, "Gracias por usar el sistema del grupo Multifiestas  :)" );
                mostrarMenu();
                break;
            }
            case 5: {
                JOptionPane.showMessageDialog(null, "Metodo en construcción... (Aquí va el apartado de eventos)" );
                mostrarMenu();
                break;
            }
            case 6: {
                JOptionPane.showMessageDialog(null, "Gracias por usar el sistema del grupo Multifiestas  :)");
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
