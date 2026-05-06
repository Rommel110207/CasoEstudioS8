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



    public Pedido(int idPedido, List<Producto> productos, String estado) {
        this.idPedido = contadorID++;
        this.productos = new ArrayList<>();
        this.estado = "Registrado";

        JOptionPane.showMessageDialog(null, "Pedido Generado #" + this.idPedido);
    }

    public Pedido() {

    }

    public void anadirProducto(Producto  p){
        productos.add(p);

        JOptionPane.showMessageDialog(null, "Pedido #" + idPedido + "Se agregó" + p.getNombre());
    }

    public void cambiarEstado(String e)
    {
        this.estado = e;
        JOptionPane.showMessageDialog(null, "Pedido #" + idPedido + "** Estado: " + this.estado);

    }

    public static int getContadorID() {
        return contadorID;
    }

    public static void setContadorID(int contadorID) {
        Pedido.contadorID = contadorID;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
