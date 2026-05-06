package cafeteria.modelos;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    // Variable estática  que actúa como Primary Key
    private static int contadorID = 1;

    private int idPedido;
    private List<Producto> productos;
    private String estado;


    public Pedido() {
        this.idPedido = contadorID++; // Asigna el ID actual y luego suma 1
        this.productos = new ArrayList<>(); // Inicializa la lista vacía
        this.estado = "Registrado"; // Estado inicial por defecto

        JOptionPane.showMessageDialog(null, "Pedido Generado #" + this.idPedido);
    }

    public void anadirProducto(Producto p)
    {
        this.productos.add(p);
        JOptionPane.showMessageDialog(null, "Pedido #" + this.idPedido + " - Se agregó: " + p.getNombre());
    }

    public void cambiarEstado(String e) {
        this.estado = e;
        JOptionPane.showMessageDialog(null, "Pedido #" + this.idPedido + " ** Estado: " + this.estado);
    }

    //Getters
    public int getIdPedido()
    {
        return idPedido;
    }

    public String getEstado()

    {
        return estado;
    }

    public List<Producto> getProductos()
    {
        return productos;
    }
}
