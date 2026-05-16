/**
 * Explorador rápido que executa tarefas com alta velocidade e eficiência.
 * Implementa Runnable para execução em thread separada.
 */
public class ExploradorRapido extends Explorador implements Runnable {
    
    // * Construtor do explorador rápido.
    public ExploradorRapido(String nome, int prioridade, String tarefa) {
        super(nome, "Rápido", prioridade, tarefa);
    }
    
    /**
     * Implementação específica da execução de tarefa para exploradores rápidos.
     * @throws TarefaInvalidaException Se a tarefa for nula ou vazia
     */
    @Override
    public void executarTarefa() throws TarefaInvalidaException {
        if (getTarefa() == null || getTarefa().trim().isEmpty()) {
            throw new TarefaInvalidaException("Tarefa inválida para " + getNome());
        }
        
        exibirStatus();
        System.out.println("Status: Iniciando exploração... [Execução em Alta Velocidade]\n");
    }
    
    /**
     * Método run() executado quando a thread é iniciada.
     */
    @Override
    public void run() {
        try {
            executarTarefa();
        } catch (TarefaInvalidaException e) {
            System.out.println("Erro: " + e.getMessage() + "\n");
        }
    }
} // Chave de fechamento da classe corrigida