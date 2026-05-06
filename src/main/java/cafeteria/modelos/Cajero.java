package cafeteria.modelos;

import javax.swing.*;
import java.util.jar.JarEntry;

public class Cajero
{

    private String nombreCajero;
    private Cocina cocina;

    public Cajero() {
    }

    public Cajero(String nombreCajero, Cocina cocina) {
        this.nombreCajero = nombreCajero;
        this.cocina = cocina;
    }

    public Pedido recibirPedido()
    {
        JOptionPane.showMessageDialog(null, "Cajero " + this.nombreCajero + " está recibiendo el pedido...");

        return new Pedido();
    }

    public void enviarAlaCocina(Pedido pedido)
    {

        JOptionPane.showMessageDialog(null, "Cajero " + this.nombreCajero + " está enviando el pedido #" + pedido.getIdPedido() + " a la cocina...");

        cocina.prepararElPedido(pedido);
    }

    public void notificarCliente()
    {
        JOptionPane.showMessageDialog(null, "Cajero " + this.nombreCajero + this.nombreCajero + "Llamando al cliente a que reciba su pedido listo " );
    }
}


