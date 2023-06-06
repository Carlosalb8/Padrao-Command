package Test;
import Command.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestauranteTest {

    @Test
    public void testExecutarTarefas() {
        Restaurante restaurante = new Restaurante();

        Pedido pedido1 = new Pedido("Pizza");
        PedidoTarefa pedidoTarefa1 = new PedidoTarefa(pedido1);
        restaurante.adicionarTarefa(pedidoTarefa1);

        Pedido pedido2 = new Pedido("Hambúrguer");
        PedidoTarefa pedidoTarefa2 = new PedidoTarefa(pedido2);
        restaurante.adicionarTarefa(pedidoTarefa2);

        restaurante.executarTarefas();

        assertEquals("Enviado", pedido1.getStatus());
        assertEquals("Enviado", pedido2.getStatus());
    }

    @Test
    public void testCancelarTarefa() {
        Restaurante restaurante = new Restaurante();

        Pedido pedido = new Pedido("Sushi");
        PedidoTarefa pedidoTarefa = new PedidoTarefa(pedido);
        restaurante.adicionarTarefa(pedidoTarefa);

        assertEquals(1, restaurante.getTarefas().size());

        restaurante.cancelarTarefa(0);

        assertEquals(0, restaurante.getTarefas().size());
        assertEquals("Cancelado", pedido.getStatus());
    }

    @Test
    public void testEntregaTarefa() {
        Restaurante restaurante = new Restaurante();

        Pedido pedido = new Pedido("Salada");
        EntregaTarefa entregaTarefa = new EntregaTarefa(pedido);
        restaurante.adicionarTarefa(entregaTarefa);

        assertEquals(1, restaurante.getTarefas().size());

        pedido.enviarPedido();

        assertEquals("Enviado", pedido.getStatus());

        restaurante.executarTarefas();

        assertEquals(0, restaurante.getTarefas().size());
        assertEquals("Entregue", pedido.getStatus());

        pedido.desfazerEntrega();

        assertEquals("Enviado", pedido.getStatus());
    }
}

