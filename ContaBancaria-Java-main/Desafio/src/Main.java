import br.com.biblioteca.Cliente;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Nathali Herpich", "Conta Corrente", 2000.00, 1);
        int opcao = 0;

        Scanner teclado = new Scanner(System.in);

        System.out.println("=========================================");
        System.out.println("Dados do cliente:");
        System.out.println("Nome: " + cliente1.getNome());
        System.out.println("CPF: 056.076.700-58");
        System.out.println("Tipo de conta: " + cliente1.getTipoDeConta());
        System.out.println("=========================================");

        while (opcao != 5) {
            System.out.println("""
                    Escolha:
                    1 - Consultar Saldo
                    2 - Depósito
                    3 - Saque
                    4 - Realizar Pix
                    5 - Sair
                    
                    Digite a opção desejada:""");

            while (!teclado.hasNextInt()) {
                System.out.println("Opção inválida. Digite um número entre 1 e 5.");
                teclado.next();
            }

            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println(cliente1.getExtrato());
                    break;

                case 2:
                    System.out.print("Digite a quantia a ser depositada: ");
                    if (teclado.hasNextDouble()) {
                        double deposito = teclado.nextDouble();
                        cliente1.setDepositaValor(deposito);
                    } else {
                        System.out.println("Valor digitado inválido.");
                        teclado.next();
                    }
                    break;

                case 3:
                    System.out.print("Digite a quantia que deseja sacar: ");
                    if (teclado.hasNextDouble()) {
                        double saque = teclado.nextDouble();
                        cliente1.setSaqueValor(saque);
                    } else {
                        System.out.println("Valor digitado inválido.");
                        teclado.next();
                    }
                    break;

                case 4:
                    System.out.print("Digite o valor do Pix (positivo para enviar, negativo para receber): ");
                    if (teclado.hasNextDouble()) {
                        double pix = teclado.nextDouble();
                        cliente1.setPix(pix);
                    } else {
                        System.out.println("Valor digitado inválido.");
                        teclado.next();
                    }
                    break;

                case 5:
                    System.out.println("Saindo... Obrigado por usar nosso sistema!");
                    break;

                default:
                    System.out.println("Opção inválida. Escolha entre 1 e 5.");
                    break;
            }
        }

        teclado.close();
    }
}
