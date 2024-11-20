package br.com.unifacisa.binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class BELTree {

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
                    System.out.println("  Inserindo " + value + " à esquerda de " + node.getValue());
                    node.setLeft(new Node(value));
                }
            } else if (value > node.getValue()) {
                if (node.getRight() != null) {
                    insert(node.getRight(), value);
                } else {
                    System.out.println("  Inserindo " + value + " à direita de " + node.getValue());
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

    // Implementação do método de busca em largura (BFS)
    public void breadthFirstSearch() {
        if (root == null) {
            System.out.println("A árvore está vazia!");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        System.out.println("Busca em largura (BFS):");
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.getValue() + " ");

            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }
    }

    public static void main(String[] args) {
        BELTree tree = new BELTree();

        // Inserção de nós na árvore
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(2);
        tree.insert(7);
        tree.insert(12);
        tree.insert(20);

        // Chamada da busca em largura (BFS)
        tree.breadthFirstSearch();
    }
}
