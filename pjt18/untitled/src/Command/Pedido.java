package Command;

public class Pedido {
    private String prato;
    private String status;

    public Pedido(String prato) {
        this.prato = prato;
        this.status = "Pendente";
    }

    public void enviarPedido() {
        this.status = "Enviado";
        System.out.println("Pedido de " + prato + " enviado.");
    }

    public void cancelarPedido() {
        this.status = "Cancelado";
        System.out.println("Pedido de " + prato + " cancelado.");
    }

    public void entregarPedido() {
        if (status.equals("Enviado")) {
            this.status = "Entregue";
            System.out.println("Pedido de " + prato + " entregue.");
        } else {
            System.out.println("Não é possível entregar o pedido de " + prato + " no momento.");
        }
    }

    public void desfazerEntrega() {
        if (status.equals("Entregue")) {
            this.status = "Enviado";
            System.out.println("Entrega do pedido de " + prato + " desfeita.");
        } else {
            System.out.println("Não é possível desfazer a entrega do pedido de " + prato + " no momento.");
        }
    }

    public String getStatus() {
        return status;
    }

}