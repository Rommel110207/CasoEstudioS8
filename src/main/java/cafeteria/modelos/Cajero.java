package cafeteria.modelos;

import javax.swing.JOptionPane;

public class Cajero {
    private String nombreCajero;
    private Cocina cocina;

    //Constructor
    public Cajero(String nombreCajero, Cocina cocina) {
        this.nombreCajero = nombreCajero;
        this.cocina = cocina;
    }

    //Recibir pedido
    public Pedido recibirPedido() {
        JOptionPane.showMessageDialog(null, " Cajero " + this.nombreCajero + " está registrando un nuevo pedido...");
        return new Pedido();
    }

    //Enviar a la cocina
    public void enviarAlaCocina(Pedido pedido) {
        JOptionPane.showMessageDialog(null, "Cajero " + this.nombreCajero + " envió el Pedido #" + pedido.getIdPedido() + " a la cocina.");
        cocina.prepararElPedido(pedido); // Llama al método de la cocina
    }

    //Notificar al cliente
    public void notificarCliente() {

        JOptionPane.showMessageDialog(null, " Cajero " + this.nombreCajero + ": ¡Llamando al cliente! Su pedido está listo en mostrador.");
    }
}


