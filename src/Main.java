import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner prompt = new Scanner(System.in);
        Company company = new Company("Robson Construções");
        int decision = 0;
        while (decision != 9) {
            System.out.println("""
                    Lista de operações disponíveis:
                    1 - Adicionar cargo
                    2 - Adicionar funcionário
                    3 - Mostrar relatório
                    4 - Mostrar folha de pagamento para um cargo
                    5 - Promover um funcionário
                    6 - Demitir um funcionário
                    """);
            try {
                decision = Integer.parseInt(prompt.nextLine());
            } catch (Exception e) {
                System.out.println("Comando inválido.");
            }
            if (decision == 1) {
                company.addJob();
            } else if (decision == 2) {
                company.hire();
            } else if (decision == 3) {
                company.report();
            } else if (decision == 4) {
                System.out.println("Insira o cargo desejado para consulta.");
                try {
                    company.payroll(Integer.parseInt(prompt.nextLine()));
                } catch (Exception e) {
                    System.out.println("O código inserido não é um número. Tente novamente.");
                }
            } else if (decision == 5) {
                System.out.println("Insira o código do funcionário que deseja promover.");
                company.report();                
                try {
                    company.promote(Integer.parseInt(prompt.nextLine()));
                } catch (Exception e) {
                    System.out.println("O código inserido não é um número. Tente novamente.");
                }
            } else if (decision == 6) {
                System.out.println("Insira o código do funcionário que deseja demitir.");
                company.report();                
                try {
                    company.fire(Integer.parseInt(prompt.nextLine()));
                } catch (Exception e) {
                    System.out.println("O código inserido não é um número. Tente novamente.");
                }
            } else if (decision != 9) {
                System.out.println("Comando indisponível.");
            }
        }
    }
}
