package clientes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        String dateTime = DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm a")
                    .format(LocalDateTime.now());
 
        System.out.println(dateTime); 
        
        Menu m = new Menu();
        m.mostrarMenu();
    }
}
