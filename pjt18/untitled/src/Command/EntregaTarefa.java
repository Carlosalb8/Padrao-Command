package Command;

public class EntregaTarefa implements Tarefa {
    private Pedido pedido;

    public EntregaTarefa(Pedido pedido) {
        this.pedido = pedido;
    }

    public void executar() {
        this.pedido.entregarPedido();
    }

    public void cancelar() {
        this.pedido.desfazerEntrega();
    }
}