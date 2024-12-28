import java.util.ArrayList;
import java.util.Scanner;

public class TattooStudio {

    // Classe que representa um item de estoque
    static class Agulha {
        String tipo;
        int quantidade;

        public Agulha(String tipo, int quantidade) {
            this.tipo = tipo;
            this.quantidade = quantidade;
        }

        @Override
        public String toString() {
            return "Agulha{" +
                    "tipo='" + tipo + '\'' +
                    ", quantidade=" + quantidade +
                    '}';
        }
    }

    public static void main(String[] args) {
        System.out.println("Bem-vindo à MyyTatua!");
        Scanner scanner = new Scanner(System.in);

        // Lista para armazenar o estoque de agulhas
        ArrayList<Agulha> estoque = new ArrayList<>();

        int opcao;
        do {
            // Menu interativo
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar agulha ao estoque");
            System.out.println("2. Remover agulha do estoque");
            System.out.println("3. Listar estoque");
            System.out.println("4. Consultar agulha");
            System.out.println("0. Sair");
            System.out.print("Opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1 -> { // Adicionar
                    System.out.print("Digite o tipo da agulha: ");
                    String tipo = scanner.nextLine();
                    System.out.print("Digite a quantidade: ");
                    int quantidade = scanner.nextInt();
                    estoque.add(new Agulha(tipo, quantidade));
                    System.out.println("Agulha adicionada com sucesso!");
                }
                case 2 -> { // Remover
                    System.out.print("Digite o tipo da agulha para remover: ");
                    String tipo = scanner.nextLine();
                    Agulha agulhaRemover = null;
                    for (Agulha agulha : estoque) {
                        if (agulha.tipo.equalsIgnoreCase(tipo)) {
                            agulhaRemover = agulha;
                            break;
                        }
                    }
                    if (agulhaRemover != null) {
                        estoque.remove(agulhaRemover);
                        System.out.println("Agulha removida com sucesso!");
                    } else {
                        System.out.println("Agulha não encontrada.");
                    }
                }
                case 3 -> { // Listar
                    System.out.println("Estoque atual:");
                    if (estoque.isEmpty()) {
                        System.out.println("O estoque está vazio.");
                    } else {
                        for (Agulha agulha : estoque) {
                            System.out.println(agulha);
                        }
                    }
                }
                case 4 -> { // Consultar
                    System.out.print("Digite o tipo da agulha para consultar: ");
                    String tipo = scanner.nextLine();
                    boolean encontrada = false;
                    for (Agulha agulha : estoque) {
                        if (agulha.tipo.equalsIgnoreCase(tipo)) {
                            System.out.println(agulha);
                            encontrada = true;
                        }
                    }
                    if (!encontrada) {
                        System.out.println("Agulha não encontrada no estoque.");
                    }
                }
                case 0 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
