
package multifiesta;

import javax.swing.JOptionPane;


public class Menu {
        
    private int opcion;
    Lista lsc = new Lista();
    
    public void mostrarMenuR() {
        
         opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "-- MENÚ PRINCIPAL --\n\n"
                + "1. Registrarme\n"
                + "2. Iniciar Sesión\n"
                + "3. Salir del sistema\n\n"
                + "Digite su opción:"));
        
        switch (opcion) {
            case 1: {
                lsc.agregar();
                JOptionPane.showMessageDialog(null, "Usuario registrado con exito" );
                mostrarMenuR();
                break;
            }
            case 2: {
                lsc.login();
                break;
            }
            case 3: {
                System.exit(0);
                break;
            }
            default: {
                JOptionPane.showMessageDialog(null,
                        "¡Opción invalida, ingrese una de las opciones validas del menu!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void mostrarMenuL() {
        opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "-- MENÚ PRINCIPAL --\n\n"
                
                + "1. Mostrar clientes por nombre\n"
                + "2. Inactivar Usuario\n"
                + "3. Mostrar Catalogo de eventos\n"
                + "4. Salir del sistema\n\n"
                + "Digite su opción:"));
        
        switch (opcion) {
            case 1: {
                lsc.mostrarPorNombre();
                mostrarMenuL();
                break;
            }
            case 2: {
                lsc.inactivar_usuario();
                mostrarMenuL();
                break;
            }
            case 3: {
                JOptionPane.showMessageDialog(null, "Metodo en construcción" );
                mostrarMenuL();
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
    
   