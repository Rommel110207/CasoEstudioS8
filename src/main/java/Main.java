

import cafeteria.modelos.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Pedido> historialPedidos = new ArrayList<>();

    public static void main(String[] args) {
        Cocina cocina = new Cocina();
        Cajero cajero = new Cajero("José", cocina);
        int opcion = 0;

        String menu = "*** GESTIÓN DE PEDIDOS ***\n"
                + "1. Nuevo Pedido \n"
                + "2. Añadir Producto a un Pedido\n"
                + "3. Ver Historial Detallado\n"
                + "4. Procesar y Entregar Pedido\n"
                + "5. Borrar Pedido\n"
                + "6. Salir\n\n"
                + "Seleccione una opción:";

        do {
            String input = JOptionPane.showInputDialog(null, menu, "Java Café", JOptionPane.QUESTION_MESSAGE);

            if (input == null) {
                opcion = 6;
                break;
            }

            try {
                opcion = Integer.parseInt(input);

                switch (opcion) {
                    case 1: // Nuevo pedido
                        String nCli = JOptionPane.showInputDialog("Nombre del Cliente:");
                        if (nCli != null && !nCli.trim().isEmpty()) {
                            Cliente cliente = new Cliente(nCli);
                            cliente.hacerPedido();

                            // El cajero crea el pedido (Aquí nacerá con ID automático y estado "Registrado")
                            Pedido p = cajero.recibirPedido();
                            historialPedidos.add(p);
                        }
                        break;

                    case 2: // Agregar Producto
                        int idA = leerId();
                        Pedido pA = buscarPedido(idA);

                        if (pA != null) {

                            if ("Registrado".equals(pA.getEstado())) {
                                String nomP = JOptionPane.showInputDialog("Nombre del Producto:");
                                if(nomP == null || nomP.trim().isEmpty()) break;

                                String preP = JOptionPane.showInputDialog("Precio:");
                                try {
                                    double precio = Double.parseDouble(preP);
                                    pA.anadirProducto(new Producto(nomP, precio));
                                } catch (NumberFormatException ex) {
                                    JOptionPane.showMessageDialog(null, "Precio inválido. Debe ser un número.");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "No se pueden añadir productos. El pedido #" + pA.getIdPedido() + " está: " + pA.getEstado());
                            }
                        }
                        break;

                    case 3: // Historial detallado
                        if (historialPedidos.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "No hay pedidos registrados.");
                        } else {
                            StringBuilder sb = new StringBuilder("--- HISTORIAL ---\n");
                            for (Pedido p : historialPedidos) {
                                sb.append("Pedido #").append(p.getIdPedido())
                                        .append(" [Estado: ").append(p.getEstado()).append("]\n");
                            }
                            JOptionPane.showMessageDialog(null, sb.toString());
                        }
                        break;

                    case 4: // Procesar pedido
                        int idP = leerId();
                        Pedido pP = buscarPedido(idP);

                        if (pP != null) {
                            if ("Registrado".equals(pP.getEstado())) {
                                cajero.enviarAlaCocina(pP);
                                // Validamos si la cocina lo terminó (Revisa que tu Cocina asigne "¡Listo!")
                                if ("¡Listo!".equals(pP.getEstado()) || "Listo".equals(pP.getEstado())) {
                                    cajero.notificarCliente();
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "El pedido #" + pP.getIdPedido() + " ya fue enviado a cocina anteriormente.");
                            }
                        }
                        break;

                    case 5: // Borrar pedido
                        int idB = leerId();
                        Pedido pB = buscarPedido(idB);
                        if (pB != null) {
                            historialPedidos.remove(pB);
                            JOptionPane.showMessageDialog(null, "Pedido #" + idB + " eliminado exitosamente.");
                        }
                        break;

                    case 6: // Salir
                        JOptionPane.showMessageDialog(null, "Saliendo del sistema de cafetería...");
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida. Por favor elija un número del 1 al 6.");
                        break;
                }

            } catch (NumberFormatException e) {
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
            if (s == null || s.trim().isEmpty()) return -1;
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}