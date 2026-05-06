

import cafeteria.modelos.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Pedido> historialPedidos = new ArrayList<>();

    public static void main(String[] args) {
        Cocina cocina = new Cocina();
        Cajero cajero = new Cajero("Ana", cocina);
        int opcion = 0;

        String menu = "--- GESTIÓN DE PEDIDOS ---\n"
                + "1. Nuevo Pedido (Registrar Cliente)\n"
                + "2. Añadir Producto a un Pedido\n"
                + "3. Ver Historial Detallado\n"
                + "4. Procesar y Entregar Pedido\n"
                + "5. Borrar Pedido\n"
                + "6. Salir\n\n"
                + "Seleccione una opción:";

        do {
            String input = JOptionPane.showInputDialog(null, menu, "Java Café", JOptionPane.QUESTION_MESSAGE);

            // Si el usuario presiona "Cancelar" o la "X" de la ventana
            if (input == null) {
                opcion = 6;
                break;
            }

            // El Try-Catch envuelve a la lista (switch)
            try {
                opcion = Integer.parseInt(input);

                // La "lista" de opciones dentro del try
                switch (opcion) {
                    case 1: // CREAR
                        String nCli = JOptionPane.showInputDialog("Nombre del Cliente:");
                        if (nCli != null && !nCli.trim().isEmpty()) {
                            Cliente cliente = new Cliente(nCli);
                            cliente.hacerPedido();
                            Pedido p = cajero.recibirPedido();
                            historialPedidos.add(p);
                        }
                        break;

                    case 2: // AÑADIR PRODUCTO
                        int idA = leerId();
                        Pedido pA = buscarPedido(idA);
                        if (pA != null && "Registrado".equals(pA.getEstado())) {
                            String nomP = JOptionPane.showInputDialog("Nombre del Producto:");
                            String preP = JOptionPane.showInputDialog("Precio:");
                            try {
                                double precio = Double.parseDouble(preP);
                                pA.anadirProducto(new Producto(nomP, precio));
                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(null, "Precio inválido. Debe ser un número.");
                            }
                        } else if (pA != null) {
                            JOptionPane.showMessageDialog(null, "No se pueden añadir productos a un pedido que ya está procesado.");
                        }
                        break;

                    case 3: // VER LISTA
                        if (historialPedidos.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "No hay pedidos registrados.");
                        } else {
                            StringBuilder sb = new StringBuilder("--- HISTORIAL ---\n");
                            for (Pedido p : historialPedidos) {
                                sb.append("Pedido #").append(p.getIdPedido())
                                        .append(" [").append(p.getEstado()).append("]\n");
                            }
                            JOptionPane.showMessageDialog(null, sb.toString());
                        }
                        break;

                    case 4: // PROCESAR
                        int idP = leerId();
                        Pedido pP = buscarPedido(idP);
                        if (pP != null) {
                            cajero.enviarAlaCocina(pP);

                            // Si en tu Cocina cambia el estado a "¡Listo!"
                            if ("¡Listo!".equals(pP.getEstado()) || "Listo".equals(pP.getEstado())) {
                                cajero.notificarCliente(); // Solo se llama aquí, no se repite el nombre
                            }
                        }
                        break;

                    case 5: // BORRAR
                        int idB = leerId();
                        Pedido pB = buscarPedido(idB);
                        if (pB != null) {
                            historialPedidos.remove(pB);
                            JOptionPane.showMessageDialog(null, "Pedido eliminado exitosamente.");
                        }
                        break;

                    case 6: // SALIR
                        JOptionPane.showMessageDialog(null, "Saliendo del sistema de cafetería...");
                        break;

                    // El default al final de la lista, pero dentro del switch
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida. Por favor elija un número del 1 al 6.");
                        break;
                }

            } catch (NumberFormatException e) {
                // El catch se encarga de atrapar letras o símbolos raros
                JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número entero válido.");
            }

        } while (opcion != 6);
    }

    // --- MÉTODOS AUXILIARES ---
    private static Pedido buscarPedido(int id) {
        for (Pedido p : historialPedidos) {
            if (p.getIdPedido() == id) {
                return p;
            }
        }
        if (id != -1) {
            JOptionPane.showMessageDialog(null, "No se encontró el pedido #" + id);
        }
        return null;
    }

    private static int leerId() {
        try {
            String s = JOptionPane.showInputDialog("Ingrese el ID del Pedido:");
            if (s == null) return -1;
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
