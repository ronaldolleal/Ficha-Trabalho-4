
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

            System.out.println("\n");

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

    /**
     * Method to enter the parking.
     * 
     * this method is used to enter the parking.
     * 
     * @param scanner Scanner object used to read user input.
     */
    private void entrarEstacionamento(Scanner scanner) {

        if (lugaresOcupados < lotacao_maxima) {

            System.out.print("\nDigite o seu nome: ");
            String nome = scanner.nextLine();

            System.out.print("Digite a matrícula do carro: ");
            String matricula = scanner.nextLine();

            System.out.print("Digite o tempo de estacionamento em minutos: ");
            int tempo = scanner.nextInt();

            scanner.nextLine(); // Limpa o buffer

            double valorAPagar = calcularValor(tempo);
            System.out.println("Valor a pagar: €" + valorAPagar);

            alunos.add(new Aluno(nome, matricula, tempo, valorAPagar));

            lugaresOcupados++;

            // nao percebi porque
            // salvarEstacionamento(nome, matricula, tempo, valorAPagar);

        } else {

            System.out.println("O parque está cheio. Não é possível entrar.");

        }

    }

    /**
     * Method to leave the parking.
     * 
     * This method is used to leave the parking. It asks for the car's license plate
     * and checks if it is in the list of parked cars.
     * 
     * @param scanner Scanner object used to read user input.
     */
    private void sairEstacionamento(Scanner scanner) {

        System.out.print("\nDigite a matrícula do carro: ");
        String matricula = scanner.nextLine();

        Aluno aluno = checkMatriculas(matricula);

        if (aluno != null) {

            System.out.println("Você saiu do estacionamento.");

            alunos.remove(aluno);

            lugaresOcupados--;

        } else {

            System.out.println("O veículo não está no parque.");
        }

    }

    /**
     * Checks if a car is parked in the parking lot.
     * 
     * This method takes a car's license plate as argument and checks if it is in
     * the list of parked cars.
     * 
     * @param matricula The car's license plate to be checked.
     * @return The Aluno object of the car if it is parked, null otherwise.
     */
    private Aluno checkMatriculas(String matricula) {

        for (Aluno aluno : alunos) {

            if (aluno.getMatricula().equals(matricula)) {

                return aluno;
            }
        }
        return null;
    }

    /**
     * Method to calculate the price of a parking stay.
     * 
     * This method takes the time in minutes as an argument and returns the price of
     * the parking stay.
     * The price is calculated by rounding up the time to the nearest multiple of 15
     * and multiplying it by the parking tariff.
     * 
     * @param minutos The time in minutes.
     * @return The price of the parking stay.
     */
    private double calcularValor(int minutos) {

        return Math.ceil(minutos / 15.0) * tarifa;

    }
}
