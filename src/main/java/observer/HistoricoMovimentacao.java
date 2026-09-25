package observer;

import java.util.ArrayList;
import java.util.List;

public class HistoricoMovimentacao implements IObservador {

    private final List<String> registros = new ArrayList<>();

    @Override
    public void atualizar(String produto, int quantidadeAtual) {
        registros.add(produto + " -> " + quantidadeAtual);
    }

    public List<String> getRegistros() {
        return registros;
    }
}