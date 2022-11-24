package multifiesta;

public class Clientes {

    private String nombre;
    private String username;
    private String password;
    private String estado;
    private String inac;

    public Clientes() {
        this.nombre = "";
        this.username = "";
        this.password = "";
        this.estado = "Activo";
        this.inac = "Inactivo";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getInac() {
        return inac;
    }

    public void setInac(String inac) {
        this.inac = inac;
    }

}
