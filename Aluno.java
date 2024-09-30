public class Aluno { 

    private String nome; 
    private String matricula; 
    private int tempo; 
    private double valor; 

    public Aluno(String nome, String matricula, int tempo, double valor) { 
        this.nome = nome; 
        this.matricula = matricula; 
        this.tempo = tempo; 
        this.valor = valor; 
    } 

    public String getMatricula() { 
        return matricula; 
    } 

} 