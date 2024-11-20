package br.com.unifacisa.binaryTrees;

import java.util.HashMap;
import java.util.Map;

public class BinaryToMatriz {

    private Node root = null;
    private final Map<Integer, Integer> nodeIndexMap = new HashMap<>();
    private int currentIndex = 0;

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

    public int[][] toAdjacencyMatrix() {
        assignIndices(root);
        int size = nodeIndexMap.size();
        int[][] matrix = new int[size][size];

        fillMatrix(root, matrix);

        return matrix;
    }

    private void assignIndices(Node node) {
        if (node != null) {
            nodeIndexMap.put(node.getValue(), currentIndex++);
            assignIndices(node.getLeft());
            assignIndices(node.getRight());
        }
    }

    private void fillMatrix(Node node, int[][] matrix) {
        if (node != null) {
            int parentIndex = nodeIndexMap.get(node.getValue());

            if (node.getLeft() != null) {
                int leftIndex = nodeIndexMap.get(node.getLeft().getValue());
                matrix[parentIndex][leftIndex] = 1;
                matrix[leftIndex][parentIndex] = 1;
            }

            if (node.getRight() != null) {
                int rightIndex = nodeIndexMap.get(node.getRight().getValue());
                matrix[parentIndex][rightIndex] = 1;
                matrix[rightIndex][parentIndex] = 1;
            }

            fillMatrix(node.getLeft(), matrix);
            fillMatrix(node.getRight(), matrix);
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        //Testando visualização:

        BinaryToMatriz tree = new BinaryToMatriz();

        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(2);
        tree.insert(7);
        tree.insert(12);
        tree.insert(20);

        System.out.println("Matriz de Adjacência:");
        int[][] matrix = tree.toAdjacencyMatrix();
        printMatrix(matrix);
    }
}

