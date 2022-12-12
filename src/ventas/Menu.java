package ventas;

import javax.swing.JOptionPane;

public class Menu {

    private int opc;
    Arbol a = new Arbol();

    public void mostrarMenu() {
        Menu m = new Menu();
        opc = Integer.parseInt(JOptionPane.showInputDialog(null,
                "-- MENÚ PRINCIPAL --\n"
                + "1. Comprar asientos\n"
                + "2. Modificar asiento\n"
                + "3. Mostrar asientos\n"
                + "4. Cancelar asientos\n"
                + "5. Salir\n"
                + "Digite su opción:"));
        switch (opc) {
            case 1: {
                a.inserta();
                mostrarMenu();
                break;
            }
            case 2: {
                a.modificarAsiento();
                mostrarMenu();
                break;
            }
            case 3: {
                a.mostrarRaiz();
                mostrarMenu();
                break;
            }
            case 4: {
                a.cancelarAsiento();
                mostrarMenu();
                break;
            }
            case 5: {
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
