package cafeteria.modelos;
import javax.swing.JOptionPane;

public class Cliente
{
    private String nombreCliente;

    public Cliente() {
    }
    public Cliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void hacerPedido()
    {
        JOptionPane.showMessageDialog(null, "Cliente " + this.nombreCliente + ": Quiero hacer un pedido por favor");

    }

    public String getNombreCliente()
    {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente)
    {
        this.nombreCliente = nombreCliente;
    }
}
