public class ListaDeMercado {
    private String[] itens;
    private int tamanho;

    public ListaDeMercado(int capacidadeInicial) {
        this.itens = new String[capacidadeInicial];
        this.tamanho = 0;
    }

    // Adicionar itens à lista
    public void adicionarItem(String item) {
        if (tamanho == itens.length) {
            redimensionar();
        }
        itens[tamanho++] = item;     }

    // Remover um item pelo índice
    public void removerItem(int indice) {
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }
        for (int i = indice; i < tamanho - 1; i++) {
            itens[i] = itens[i + 1];
        }
        itens[--tamanho] = null;
    }

    // Exibir todos os itens da lista
    public void exibirLista() {
        if (tamanho == 0) {
            System.out.println("A lista está vazia.");
            return;
        }
        System.out.println("Lista de Mercado:");
        for (int i = 0; i < tamanho; i++) {
            System.out.println((i + 1) + ". " + itens[i]);
        }
    }

    // Redimensionar o array
    private void redimensionar() {
        String[] novoArray = new String[itens.length * 2];
        System.arraycopy(itens, 0, novoArray, 0, itens.length);
        itens = novoArray;
    }

    // Retornar tamanho da lista
    public int getTamanho() {
        return tamanho;
    }
}