package cafeteria.modelos;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class Pedido
{
    private static int contadorID= 1;
    private int idPedido;
    private List<Producto> productos;
    private String estado;

    public Pedido()
    {

    }

    public Pedido(int idPedido, List<Producto> productos, String estado) {
        this.idPedido = contadorID++;
        this.productos = new ArrayList<>();
        this.estado = "Registrado";

        JOptionPane.showMessageDialog(null, "Pedido Generado #" + this.idPedido);
    }

    public void anadirProducto(Producto  p){
        productos.add(p);

        JOptionPane.showMessageDialog(null, "Pedido #" + idPedido + "Se agregó" + p.getNombre());
    }
}
