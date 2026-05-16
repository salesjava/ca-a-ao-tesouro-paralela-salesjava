/**
 * Exceção personalizada para tarefas nulas ou vazias.
 */
public class TarefaInvalidaException extends Exception {
    public TarefaInvalidaException(String mensagem) {
        super(mensagem);
    }
}