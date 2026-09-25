package observer;

public class PainelEstoque implements IObservador {

    private String produtoExibido;
    private int quantidadeExibida;

    @Override
    public void atualizar(String produto, int quantidadeAtual) {
        this.produtoExibido = produto;
        this.quantidadeExibida = quantidadeAtual;
        System.out.println("[Painel] " + produto + ": " + quantidadeAtual + " unidades");
    }

    public int getQuantidadeExibida() {
        return quantidadeExibida;
    }
}