import java.util.Scanner;

public class ContaBancaria {

    private String nomeTitular;
    private String numeroConta;
    private double saldo;

    public ContaBancaria(String nomeTitular, String numeroConta, double saldoInicial) {
        this.nomeTitular = nomeTitular;
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
        System.out.println("Conta bancária criada com sucesso.");
    }
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.printf("Depósito de R$ %.2f realizado com sucesso.%n", valor);
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }
    public void sacar(double valor) {
        if (valor > 5000) {
            System.out.println("Valor do saque acima do permitido.");
        } else if (valor > saldo) {
            System.out.println("Saldo insuficiente para realizar a operação.");
        } else if (valor <= 0) {
            System.out.println("Valor inválido para saque.");
        } else {
            saldo -= valor;
            System.out.printf("Saque de R$ %.2f realizado com sucesso.%n", valor);
        }
    }
    public void exibirSaldo() {
        System.out.printf("Saldo atual: R$ %.2f%n", saldo);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("==== ABERTURA DE CONTA BANCÁRIA ====");
            System.out.print("Nome do titular: ");
            String nome = scanner.nextLine();

            System.out.print("Número da conta: ");
            String numeroConta = scanner.nextLine();

            System.out.print("Saldo inicial: R$ ");
            double saldoInicial = scanner.nextDouble();

            
            ContaBancaria conta = new ContaBancaria(nome, numeroConta, saldoInicial);

            String opcao;
            do {
                System.out.println("\n==== MENU DE OPERAÇÕES ====");
                System.out.println("1 - Depositar");
                System.out.println("2 - Sacar");
                System.out.println("3 - Consultar Saldo");
                System.out.println("Q - Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.next();

                switch (opcao) {
                    case "1":
                        System.out.print("Digite o valor para depósito: R$ ");
                        double deposito = scanner.nextDouble();
                        conta.depositar(deposito);
                        break;
                    case "2":
                        System.out.print("Digite o valor para saque: R$ ");
                        double saque = scanner.nextDouble();
                        conta.sacar(saque);
                        break;
                    case "3":
                        conta.exibirSaldo();
                        break;
                    case "Q":
                    case "q":
                        System.out.println("Encerrando o programa...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } while (!opcao.equalsIgnoreCase("Q"));

        } catch (Exception e) {
            System.out.println("Erro na entrada de dados. Encerrando programa.");
        } 
        finally {
            scanner.close();
        }
    }
}
