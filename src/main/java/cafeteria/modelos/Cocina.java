package cafeteria.modelos;
import javax.swing.JOptionPane;

public class Cocina
{
    public void prepararElPedido(Pedido pedido)
    {
        JOptionPane.showMessageDialog(null, "Cocinando el pedido #" + pedido.getIdPedido() + "...");
        pedido.cambiarEstado("En preparación");

        JOptionPane.showMessageDialog(null, "Cocinando el pedido #" +  pedido.getIdPedido() + "...");

        pedido.cambiarEstado("¡Listo!");

        JOptionPane.showMessageDialog(null, "Pedido #" + pedido.getIdPedido() + " está listo para su entrega.");
    }
}
