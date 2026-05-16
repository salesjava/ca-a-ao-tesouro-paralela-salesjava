/**
 * Classe abstrata que representa um explorador na Caça ao Tesouro Paralela.
 * Define a estrutura básica para diferentes tipos de exploradores.
 */
public abstract class Explorador {
    
    // Atributos encapsulados requeridos
    private String nome;
    private String tipo;
    private int prioridade;
    private String tarefa;
    
    // * Construtor que inicializa todos os atributos do explorador.
    public Explorador(String nome, String tipo, int prioridade, String tarefa) {
        this.nome = nome;
        this.tipo = tipo;
        this.prioridade = prioridade; // CORRIGIDO: de priority para prioridade
        this.tarefa = tarefa;
    }

    /**
     * Método abstrato que deve ser implementado pelas subclasses.
     * Define como cada tipo de explorador executa sua tarefa.
     * @throws TarefaInvalidaException Se a tarefa for inválida
     */
    public abstract void executarTarefa() throws TarefaInvalidaException;
    
    /**
     * Exibe o status completo do explorador com formatação clara.
     */
    public void exibirStatus() {
        System.out.println("Explorador: " + this.nome);
        System.out.println("Tipo: " + this.tipo);
        System.out.println("Prioridade: " + this.prioridade);
        System.out.println("Tarefa: " + (this.tarefa == null || this.tarefa.isEmpty() ? "[Nenhuma]" : this.tarefa));
    }
    
    // Getters para acesso aos atributos encapsulados
    public String getNome() { return nome; }
    public String getTipo() { return tipo; }
    public int getPrioridade() { return prioridade; }
    public String getTarefa() { return tarefa; }

    // Setter para sincronizar a prioridade da classe com a da Thread se necessário
    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }
}