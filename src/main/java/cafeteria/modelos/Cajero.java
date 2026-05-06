package cafeteria.modelos;

import javax.swing.JOptionPane;

public class Cajero {
    private String nombreCajero;
    private Cocina cocina;

    // CONSTRUCTOR
    public Cajero(String nombreCajero, Cocina cocina) {
        this.nombreCajero = nombreCajero; // Aquí que se guarde solo como el nombre
        this.cocina = cocina;
    }

    //  Recibir pedido
    public Pedido recibirPedido() {
        JOptionPane.showMessageDialog(null, "💁‍♀️ Cajero " + this.nombreCajero + " está registrando un nuevo pedido...");
        return new Pedido();
    }

    //  Enviar a la cocina
    public void enviarAlaCocina(Pedido pedido) {
        JOptionPane.showMessageDialog(null, "Cajero " + this.nombreCajero + " envió el Pedido #" + pedido.getIdPedido() + " a la cocina.");
        cocina.prepararElPedido(pedido); // Llama al método de la cocina
    }

    //  Notificar al cliente
    public void notificarCliente() {
        // Aquí es donde probablemente estaba el error de repetición. Ahora solo llama a this.nombreCajero una vez.
        JOptionPane.showMessageDialog(null, "📢 Cajero " + this.nombreCajero + ": ¡Llamando al cliente! Su pedido está listo en mostrador.");
    }
}


