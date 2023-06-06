package Command;

public class PedidoTarefa implements Tarefa {
    private Pedido pedido;

    public PedidoTarefa(Pedido pedido) {
        this.pedido = pedido;
    }

    public void executar() {
        this.pedido.enviarPedido();
    }

    public void cancelar() {
        this.pedido.cancelarPedido();
    }
}
