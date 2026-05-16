import java.util.ArrayList;

/**
 * Classe principal que simula a Caça ao Tesouro Paralela.
 * Demonstra o uso de threads, prioridades, tipos (user e daemon) e exceções personalizadas
 */
public class CacaAoTesouroParalela {
    
    public static void main(String[] args) {
        System.out.println("=== CAÇA AO TESOURO PARALELA ===");
        System.out.println("Exploradores em ação: threads, prioridades e exceções em Java\n");
        
        // Lista para gerenciar as threads dos exploradores
        ArrayList<Thread> listaThreads = new ArrayList<>();
        
        // Criando exploradores rápidos
        ExploradorRapido expRapido1 = new ExploradorRapido("Alice", Thread.MAX_PRIORITY, "Vasculhar a caverna");
        
        // Criando exploradores cuidadosos
        ExploradorCuidadoso expCuidadoso1 = new ExploradorCuidadoso("Bob", Thread.MIN_PRIORITY, "Mapear a floresta");
        ExploradorCuidadoso expCuidadoso2 = new ExploradorCuidadoso("Diego", Thread.MIN_PRIORITY, "Analisar runas antigas");
        
        // Criando um explorador com tarefa inválida para demonstrar exceção
        ExploradorRapido expInvalido = new ExploradorRapido("Clara", Thread.MAX_PRIORITY, "");
        
        // Encapsulando exploradores em threads
        Thread t1 = new Thread(expRapido1, expRapido1.getNome());
        Thread t2 = new Thread(expInvalido, expInvalido.getNome());
        Thread t3 = new Thread(expCuidadoso1, expCuidadoso1.getNome());
        Thread t4 = new Thread(expCuidadoso2, expCuidadoso2.getNome());
        
        // Configurando prioridades das threads
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t3.setPriority(Thread.MIN_PRIORITY);
        t4.setPriority(Thread.MIN_PRIORITY);
        
        // Configurando algumas threads como daemon (tarefas secundárias / cuidadosas)
        t3.setDaemon(true);
        t4.setDaemon(true);
        
        // Adicionando threads à lista
        listaThreads.add(t1);
        listaThreads.add(t2);
        listaThreads.add(t3);
        listaThreads.add(t4);
        
        // Exibindo informações das threads antes da execução
        System.out.println("\n=== INFORMAÇÕES DAS THREADS ===");
        for (Thread t : listaThreads) {
            System.out.println("Nome: " + t.getName() + 
                               " | Prioridade: " + t.getPriority() + 
                               " | IsDaemon: " + t.isDaemon() + 
                               " | Estado Inicial: " + t.getState());
        }
        
        // Iniciando todas as threads
        System.out.println("\n=== INICIANDO EXPLORAÇÃO ===");
        for (Thread t : listaThreads) {
            t.start();
        }
        
        // Aguardando conclusão das threads não-daemon (User Threads)
        System.out.println("\n=== AGUARDANDO CONCLUSÃO DOS EXPLORADORES ===");
        try {
            // Aguarda especificamente as threads de usuário terminarem
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("A thread principal foi interrompida.");
        }
        
        // Verificando estado final das threads após o processamento principal
        System.out.println("\n=== ESTADO FINAL DAS THREADS ===");
        for (Thread t : listaThreads) {
            System.out.println("Thread " + t.getName() + " terminada em estado: " + t.getState());
        }
        
        System.out.println("\n=== CAÇA AO TESOURO PARALELA FINALIZADA ===");
        System.out.println("Todos os exploradores principais completaram suas missões!");
    }
}