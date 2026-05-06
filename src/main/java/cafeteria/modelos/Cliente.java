package cafeteria.modelos;

public class Cliente
{
    private String nombre;
    private String apellido;

    public Cliente() {}
    public Cliente(String nombre, String apellido)
    {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String solicitarPedido()
    {
        return "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
