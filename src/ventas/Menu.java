package ventas;

import javax.swing.JOptionPane;

public class Menu {
    
    private int opc;
    Arbol a = new Arbol();

    public void mostrarMenu() {
        opc = Integer.parseInt(JOptionPane.showInputDialog(null,
                "***MENÚ PRINCIPAL***\n"
                        + "1.Agregar elemento\n"
                        + "2.MostrarElementos\n"
                        + "3.Eliminar árbol\n"
                        + "4.Salir\n"
                        + "Digite su opción: "));
        switch (opc) {
            case 1: {
                a.inserta();
                mostrarMenu();
                break;
            }
            case 2: {
                a.mostrarRaiz();
                mostrarMenu();
                break;
            }
            case 3: {
                a.eliminarTodo();
                mostrarMenu();
                break;
            }
            case 4: {
                System.exit(0);
                break;
            }
            default: {
                JOptionPane.showMessageDialog(null, "¡Opción incorrecta!");
                mostrarMenu();
            }
        }
    }
    
}
