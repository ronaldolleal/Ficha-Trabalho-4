
public class Estacionamento {

    public static void main(String[] args) {
        Estacionamento sistemaEstacionamento = new Estacionamento();
        sistemaEstacionamento.iniciar();
    }

    private static final int lotacao_maxima = 500;
    private static final double tarifa = 0.10; // Valor a pagar por 15 minutos 
    private List<Aluno> alunos;
    private int lugaresOcupados;

    public Estacionamento() {

        alunos = new ArrayList<>();

        lugaresOcupados = 0;

    }

    public void iniciar() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("1. Entrar no estacionamento");

            System.out.println("2. Sair do estacionamento");

            System.out.println("3. Sair");

            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();

            scanner.nextLine(); // Limpa o buffer 

            switch (escolha) {

                case 1:

                    entrarEstacionamento(scanner);

                    break;

                case 2:

                    sairEstacionamento(scanner);

                    break;

                case 3:

                    System.out.println("Saindo...");

                    scanner.close();

                    return;

                default:

                    System.out.println("Opção inválida.");

            }

        }

    }
}
