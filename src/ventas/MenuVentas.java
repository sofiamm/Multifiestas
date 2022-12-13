package ventas;
import javax.swing.JOptionPane;

import clientes.Menu;

public class MenuVentas {                                                       

    private int opc;
    Arbol a = new Arbol();

    public void mostrarMenu() {
        MenuVentas m = new MenuVentas();
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
                a.Ingresos_del_Dia();
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
                a.mostrarAlmacenaje();
                a.Suma();
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
