package observer;

public class AlertaEstoqueBaixo implements IObservador {

    private static final int LIMITE = 5;
    private boolean alertaDisparado;

    @Override
    public void atualizar(String produto, int quantidadeAtual) {
        if (quantidadeAtual <= LIMITE) {
            alertaDisparado = true;
            System.out.println("[ALERTA] Estoque baixo de " + produto + ": " + quantidadeAtual + " unidades");
        } else {
            alertaDisparado = false;
        }
    }

    public boolean isAlertaDisparado() {
        return alertaDisparado;
    }
}
