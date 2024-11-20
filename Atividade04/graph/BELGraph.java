package br.com.unifacisa.graph;
import br.com.unifacisa.binaryTrees.Node;

import java.util.LinkedList;
import java.util.Queue;

public class BELGraph {

    private Node root = null;

    public void insert(int value) {
        root = insert(root, value);
    }

    public Node insert(Node node, int value) {
        if (!isEmpty(node)) {
            if (value < node.getValue()) {
                if (node.getLeft() != null) {
                    insert(node.getLeft(), value);
                } else {
                    System.out.println("  Inserindo " + value + " a esqueda de " + node.getValue());
                    node.setLeft(new Node(value));
                }
            } else if (value > node.getValue()) {
                if (node.getRight() != null) {
                    insert(node.getRight(), value);
                } else {
                    System.out.println("  Inserindo " + value + " a direita de " + node.getValue());
                    node.setRight(new Node(value));
                }
            }
        } else {
            node = new Node(value);
        }
        return node;
    }

    public boolean isEmpty(Node node) {
        return node == null;
    }

    public void showRoot() {
        if (root == null) {
            System.out.println("A Arvore está vazia!");
            return;
        }
        System.out.println("Raiz " + root.getValue());
    }

    public Node remove(Node node, int value) {
        if (node == null) {
            System.out.println("A Arvore está vazia!");
            return null;
        }
        System.out.println("  Percorrendo No " + node.getValue());

        if (value < node.getValue()) {
            node.setLeft(remove(node.getLeft(), value));
        } else if (value > node.getValue()) {
            node.setRight(remove(node.getRight(), value));
        } else if (node.getLeft() != null && node.getRight() != null) {
            // 2 filhos
            System.out.println("  Removeu No " + node.getValue());
            node.setValue(findMin(node.getRight()).getValue());
            node.setRight(removeMin(node.getRight()));
        } else {
            System.out.println("  Removeu No " + node.getValue());
            node = (node.getLeft() == null) ? node.getLeft() : node.getRight();
        }
        return node;
    }

    public Node removeMin(Node node) {
        if (node == null) {
            System.out.println("  ERRO ");
        } else if (node.getLeft() != null) {
            node.setLeft(removeMin(node.getLeft()));
            return node;
        } else {
            return node.getRight();
        }
        return null;
    }

    public Node findMin(Node node) {
        if (node != null) {
            while (node.getLeft() != null) {
                node = node.getLeft();
            }
        }
        return node;
    }

    // Implementação da Busca em Largura (BFS)
    public void breadthFirstSearch() {
        if (root == null) {
            System.out.println("Árvore vazia!");
            return;
        }

        // Fila para armazenar os nós a serem visitados
        Queue<Node> queue = new LinkedList<>();
        queue.add(root); // Começa pela raiz

        while (!queue.isEmpty()) {
            Node current = queue.poll(); // Remove o nó da frente da fila
            System.out.print(current.getValue() + " "); // Processa o nó

            // Adiciona os filhos à fila
            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }
    }

    // Teste da Busca em Largura no Algoritmo
    public static void main(String[] args) {
        BELGraph tree = new BELGraph();

        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(2);
        tree.insert(7);
        tree.insert(12);
        tree.insert(20);

        System.out.println("Busca em Largura (BFS):");
        tree.breadthFirstSearch();
    }
}
