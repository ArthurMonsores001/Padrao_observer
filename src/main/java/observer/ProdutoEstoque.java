package observer;

import java.util.ArrayList;
import java.util.List;

public class ProdutoEstoque implements ISujeito {

    private final String nome;
    private int quantidade;
    private final List<IObservador> observadores = new ArrayList<>();

    public ProdutoEstoque(String nome, int quantidadeInicial) {
        this.nome = nome;
        this.quantidade = quantidadeInicial;
    }

    @Override
    public void adicionarObservador(IObservador observador) {
        observadores.add(observador);
    }

    @Override
    public void removerObservador(IObservador observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores() {
        for (IObservador observador : observadores) {
            observador.atualizar(nome, quantidade);
        }
    }

    public void venderUnidade() {
        if (quantidade > 0) {
            quantidade--;
            notificarObservadores();
        }
    }

    public void reporEstoque(int qtd) {
        quantidade += qtd;
        notificarObservadores();
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
