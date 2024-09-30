public class Estacionamento { 

    public static void main(String[] args) { 
        Estacionamento sistemaEstacionamento = new Estacionamento(); 
        sistemaEstacionamento.iniciar(); 
    } 

    private static final int lotacao_maxima = 500; 
    private static final double tarifa = 0.10; // Valor a pagar por 15 minutos 
    private List<Aluno> alunos; 
    private int lugaresOcupados; 

}