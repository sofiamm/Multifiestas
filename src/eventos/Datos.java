package eventos;

public class Datos {

    private String nombreEve;
    private String fechaEve;
    private String lugarEve;
    private String ciudad;
    private String direccionEve;
    private String estadoEve;
    private String estadoEve2;
    private long codigoArea;
    private int numeroA;
    private double costo;
    private String estadoAsiento;
    private String estadoAsiento2;

    public Datos() {
        this.nombreEve = "";
        this.fechaEve = "";
        this.lugarEve = "";
        this.ciudad = "";
        this.direccionEve = "";
        this.estadoEve = "Activo";
        this.estadoEve2 = "Inactivo";
        this.codigoArea = 0;
        this.numeroA = 0;
        this.costo = 0.00;
        this.estadoAsiento = "Libre";
        this.estadoAsiento2 = "Ocupado";

    }

    public String getNombreEve() {
        return nombreEve;
    }

    public void setNombreEve(String nombreEve) {
        this.nombreEve = nombreEve;
    }

    public String getFechaEve() {
        return fechaEve;
    }

    public void setFechaEve(String fechaEve) {
        this.fechaEve = fechaEve;
    }

    public String getLugarEve() {
        return lugarEve;
    }

    public void setLugarEve(String lugarEve) {
        this.lugarEve = lugarEve;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccionEve() {
        return direccionEve;
    }

    public void setDireccionEve(String direccionEve) {
        this.direccionEve = direccionEve;
    }

    public String getEstadoEve() {
        return estadoEve;
    }

    public void setEstadoEve(String estadoEve) {
        this.estadoEve = estadoEve;
    }

    public String getEstadoEve2() {
        return estadoEve2;
    }

    public void setEstadoEve2(String estadoEve2) {
        this.estadoEve2 = estadoEve2;
    }

    public long getCodigoArea() {
        return codigoArea;
    }

    public void setCodigoArea(long codigoArea) {
        this.codigoArea = codigoArea;
    }

    public int getNumeroA() {
        return numeroA;
    }

    public void setNumeroA(int numeroA) {
        this.numeroA = numeroA;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getEstadoAsiento() {
        return estadoAsiento;
    }

    public void setEstadoAsiento(String estadoAsiento) {
        this.estadoAsiento = estadoAsiento;
    }

    public String getEstadoAsiento2() {
        return estadoAsiento2;
    }

    public void setEstadoAsiento2(String estadoAsiento2) {
        this.estadoAsiento2 = estadoAsiento2;
    }

}
