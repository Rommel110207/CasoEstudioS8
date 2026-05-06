package cafeteria.modelos;

public class Cajero {
    private int numeroPedido;
    private String nombreCajero;


    public Cajero() {
    }

    public Cajero(int numeroPedido, String nombreCajero) {
        this.numeroPedido = numeroPedido;
        this.nombreCajero = nombreCajero;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public String getNombreCajero() {
        return nombreCajero;
    }

    public void setNombreCajero(String nombreCajero) {
        this.nombreCajero = nombreCajero;
    }
}


