package observer;

public interface ISujeito {
    void adicionarObservador(IObservador observador);
    void removerObservador(IObservador observador);
    void notificarObservadores();
}
