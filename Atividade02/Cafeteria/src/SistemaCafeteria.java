import java.util.PriorityQueue;
import java.util.Queue;

class Pedido implements Comparable<Pedido> {
    private final int id;
    private final String nomeCliente;
    private final boolean isVIP;

    public Pedido(int id, String nomeCliente, boolean isVIP) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.isVIP = isVIP;
    }

    public int getId() {
        return id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public boolean isVIP() {
        return isVIP;
    }

    // Define a prioridade: VIPs vêm primeiro
    @Override
    public int compareTo(Pedido outro) {
        if (this.isVIP && !outro.isVIP) {
            return -1; // VIP tem maior prioridade
        } else if (!this.isVIP && outro.isVIP) {
            return 1;  // Normal tem menor prioridade
        } else {
            return Integer.compare(this.id, outro.id); // Ordem de chegada
        }
    }

    @Override
    public String toString() {
        return "Pedido ID: " + id + ", Cliente: " + nomeCliente + (isVIP ? " (VIP)" : "");
    }
}

class FilaPedidos {
    private final Queue<Pedido> filaPedidos;

    public FilaPedidos() {
        filaPedidos = new PriorityQueue<>();
    }

    // Adiciona um novo pedido à fila
    public void adicionarPedido(Pedido pedido) {
        filaPedidos.offer(pedido);
        System.out.println("Pedido adicionado: " + pedido);
    }

    // Processa o próximo pedido na fila (removendo-o)
    public void processarProximoPedido() {
        Pedido proximoPedido = filaPedidos.poll();
        if (proximoPedido != null) {
            System.out.println("Processando " + proximoPedido);
        } else {
            System.out.println("Não há pedidos para processar.");
        }
    }

    // Cancela um pedido pelo ID
    public void cancelarPedido(int id) {
        filaPedidos.removeIf(pedido -> pedido.getId() == id);
        System.out.println("Pedido com ID " + id + " foi cancelado.");
    }

    // Exibe todos os pedidos pendentes sem removê-los
    public void visualizarPedidos() {
        if (filaPedidos.isEmpty()) {
            System.out.println("Não há pedidos em espera.");
        } else {
            System.out.println("Pedidos em espera:");
            for (Pedido pedido : filaPedidos) {
                System.out.println(pedido);
            }
        }
    }
}

public class SistemaCafeteria {
    public static void main(String[] args) {
        FilaPedidos filaPedidos = new FilaPedidos();

        // Adiciona alguns pedidos para teste
        filaPedidos.adicionarPedido(new Pedido(1, "Alice", false));
        filaPedidos.adicionarPedido(new Pedido(2, "Bob", true));  // VIP
        filaPedidos.adicionarPedido(new Pedido(3, "Carlos", false));
        filaPedidos.adicionarPedido(new Pedido(4, "Diana", true)); // VIP

        // Visualiza os pedidos
        filaPedidos.visualizarPedidos();

        // Processa pedidos na ordem de prioridade
        filaPedidos.processarProximoPedido(); // Deveria processar o pedido VIP do Bob
        filaPedidos.processarProximoPedido(); // Deveria processar o pedido VIP da Diana

        // Cancela um pedido
        filaPedidos.cancelarPedido(3); // Cancela o pedido do Carlos

        // Visualiza novamente após cancelamento
        filaPedidos.visualizarPedidos();

        // Processa o próximo pedido
        filaPedidos.processarProximoPedido(); // Deveria processar o pedido da Alice

        // Tenta processar novamente quando a fila está vazia
        filaPedidos.processarProximoPedido();
    }
}
