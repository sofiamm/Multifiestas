package ventas;

import eventos.Datos;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Dato extends Datos {

    private int numeroAsiento;
    private String dateTime;
   

    public Dato () {
     
        this.numeroAsiento = 0;
       this.dateTime = DateTimeFormatter.ofPattern("MMM dd yyyy, hh:mm a").format(LocalDateTime.now());
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }
    
    public String getDateTime() {
        return dateTime;
    }

}
