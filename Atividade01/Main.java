import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaDeMercado lista = new ListaDeMercado(10);
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nDigite o número correspondente à operação desejada:");
            System.out.println("1) Listar tudo");
            System.out.println("2) Adicionar item à lista de mercado");
            System.out.println("3) Remover item");
            System.out.println("4) Sair");
            System.out.print("Sua opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    lista.exibirLista();             // Listar tudo
                    break;

                case 2:
                    System.out.print("Digite o item para adicionar: ");
                    String item = scanner.nextLine(); // Lê o item do usuário
                    lista.adicionarItem(item);       // Adiciona o item à lista
                    System.out.println("Item adicionado!");
                    break;

                case 3:
                    lista.exibirLista();             // Lista os itens antes de remover
                    if (lista.getTamanho() > 0) {
                        System.out.print("Digite o número do item que deseja remover: ");
                        int indice = scanner.nextInt() - 1;
                        try {
                            lista.removerItem(indice); // Remove o item pelo índice
                            System.out.println("Item removido!");
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Erro: índice inválido.");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Saindo do programa. Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 4);

        scanner.close();
    }
}
