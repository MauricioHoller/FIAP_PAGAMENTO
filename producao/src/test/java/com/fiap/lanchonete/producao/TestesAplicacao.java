import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestesAplicacao {

    @Test
    public void testVisualizacaoFilaPedidos() {
        // Dado
        Usuario usuario = new Usuario("username", "senha");
        Aplicacao aplicacao = new Aplicacao();
        
        // Quando
        boolean filaExi	bida = aplicacao.exibirFilaPedidos(usuario);
        
        // Então
        assertTrue(filaExibida);
    }

    @Test
    public void testAtualizacaoStatusPedidos() {
        // Dado
        Usuario usuario = new Usuario("username", "senha");
        Pedido pedido = new Pedido();
        Aplicacao aplicacao = new Aplicacao();
        
        // Quando
        boolean statusAtualizado = aplicacao.atualizarStatusPedido(usuario, pedido, "Em processamento");
        
        // Então
        assertTrue(statusAtualizado);
    }

    @Test
    public void testEnvioEventoStatusAtualizado() {
        // Dado
        Pedido pedido = new Pedido();
        Aplicacao aplicacao = new Aplicacao();
        
        // Quando
        boolean eventoEnviado = aplicacao.enviarEventoStatusAtualizado(pedido);
        
        // Então
        assertTrue(eventoEnviado);
    }
}
