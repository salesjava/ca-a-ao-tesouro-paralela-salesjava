/**
 * Explorador cuidadoso que executa tarefas com precisão e atenção aos detalhes.
 * Implementa Runnable para execução em thread separada.
 */
public class ExploradorCuidadoso extends Explorador implements Runnable {
    
    // * Construtor do explorador cuidadoso.
    public ExploradorCuidadoso(String nome, int prioridade, String tarefa) {
        super(nome, "Cuidadoso", prioridade, tarefa);
    }
    
    /**
     * Implementação específica da execução de tarefa para exploradores cuidadosos.
     * @throws TarefaInvalidaException Se a tarefa for nula ou vazia
     */
    @Override
    public void executarTarefa() throws TarefaInvalidaException {
        if (getTarefa() == null || getTarefa().trim().isEmpty()) {
            throw new TarefaInvalidaException("Tarefa inválida para " + getNome());
        }
        
        exibirStatus();
        System.out.println("Status: Iniciando exploração... [Análise detalhada do terreno]\n");
    }
    
    /**
     * Método run() executado quando a thread é iniciada.
     */
    @Override
    public void run() {
        try {
            // Simulando cautela/atraso intencional antes de agir
            Thread.sleep(200);
            executarTarefa();
        } catch (TarefaInvalidaException e) {
            System.out.println("Erro: " + e.getMessage() + "\n");
        } catch (InterruptedException e) {
            System.out.println("A exploração de " + getNome() + " foi interrompida.");
        }
    }
}