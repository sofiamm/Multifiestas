package multifiesta;

public class Eventos_Datos {
    private String nombnreE;
    private String fecha;
    private String lugar;
    private String estado;
    private long codigo_area;
    private int numeroA;
    private double costo;
    private String estado2;
    private String dirección;

    public Eventos_Datos(){
        this.nombnreE="";
        this.fecha="";
        this.lugar="";
        this.estado="Activo";
        this.codigo_area=0;
        this.numeroA=0;
        this.costo=0.00;
        this.estado2="Inactivo";
        this.dirección="";

    }

    public String getNombnreE() {
        return nombnreE;
    }

    public void setNombnreE(String nombnreE) {
        this.nombnreE = nombnreE;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public long getCodigo_area() {
        return codigo_area;
    }

    public void setCodigo_area(long codigo_area) {
        this.codigo_area = codigo_area;
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

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado2() {
        return estado2;
    }

    public void setEstado2(String estado2) {
        this.estado2 = estado2;
    }

    
}
