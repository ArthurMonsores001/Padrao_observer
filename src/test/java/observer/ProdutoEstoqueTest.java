package observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoEstoqueTest {

    private ProdutoEstoque produto;
    private PainelEstoque painel;
    private AlertaEstoqueBaixo alerta;
    private HistoricoMovimentacao historico;

    @BeforeEach
    void setUp() {
        produto = new ProdutoEstoque("Mouse", 10);
        painel = new PainelEstoque();
        alerta = new AlertaEstoqueBaixo();
        historico = new HistoricoMovimentacao();
    }

    @Test
    void deveNotificarTodosOsObservadoresRegistrados() {
        produto.adicionarObservador(painel);
        produto.adicionarObservador(historico);

        produto.venderUnidade();

        assertEquals(9, painel.getQuantidadeExibida());
        assertEquals(1, historico.getRegistros().size());
        assertEquals("Mouse -> 9", historico.getRegistros().get(0));
    }

    @Test
    void naoDeveNotificarObservadorRemovido() {
        produto.adicionarObservador(painel);
        produto.adicionarObservador(historico);

        produto.removerObservador(painel);
        produto.venderUnidade();

        assertEquals(0, painel.getQuantidadeExibida());
        assertEquals(1, historico.getRegistros().size());
    }

    @Test
    void deveDispararAlertaQuandoEstoqueFicaAbaixoDoLimite() {
        produto = new ProdutoEstoque("Mouse", 6);
        produto.adicionarObservador(alerta);

        produto.venderUnidade();

        assertTrue(alerta.isAlertaDisparado());
    }

    @Test
    void naoDeveDispararAlertaQuandoEstoqueEstaAcimaDoLimite() {
        produto.adicionarObservador(alerta);

        produto.venderUnidade();

        assertFalse(alerta.isAlertaDisparado());
    }

    @Test
    void deveRegistrarHistoricoAposReposicao() {
        produto.adicionarObservador(historico);

        produto.reporEstoque(20);

        assertEquals(1, historico.getRegistros().size());
        assertEquals("Mouse -> 30", historico.getRegistros().get(0));
    }
}