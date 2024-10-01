
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

    private void entrarEstacionamento(Scanner scanner) {

        if (lugaresOcupados < lotacao_maxima) {

            System.out.print("Digite o seu nome: ");

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

            salvarEstacionamento(nome, matricula, tempo, valorAPagar);

        } else {

            System.out.println("O parque está cheio. Não é possível entrar.");

        }

    }

    private void sairEstacionamento(Scanner scanner) {

        System.out.print("Digite a matrícula do carro: ");

        String matricula = scanner.nextLine();

        boolean encontrado = false;

        for (Aluno aluno : alunos) {

            if (aluno.getMatricula().equals(matricula)) {

                System.out.println("Você saiu do estacionamento.");

                alunos.remove(aluno);

                lugaresOcupados--;

                encontrado = true;

                break;

            }

        }

        if (!encontrado) {

            System.out.println("Matrícula não encontrada.");

        }

    }

    private double calcularValor(int minutos) {

        return Math.ceil(minutos / 15.0) * tarifa;

    }
}
