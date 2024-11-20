package br.com.unifacisa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GrafoToMatriz {

    private final int numVertices;
    private final List<LinkedList<Integer>> adjacencyList;

    public GrafoToMatriz(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyList = new ArrayList<>(numVertices);

        for (int i = 0; i < numVertices; i++) {
            this.adjacencyList.add(new LinkedList<>());
        }
    }

    public void addEdge(int v, int w) {
        // v = origem, w = destino
        adjacencyList.get(v).add(w);
        adjacencyList.get(w).add(v);
    }

    public int[][] toAdjacencyMatrix() {
        int[][] matrix = new int[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++) {
            for (int neighbor : adjacencyList.get(i)) {
                matrix[i][neighbor] = 1;
                matrix[neighbor][i] = 1;
            }
        }

        return matrix;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numVertices; i++) {
            sb.append("Vértice: ").append(i).append(":\n");
            for (Integer neighbor : adjacencyList.get(i)) {
                sb.append(" -> ").append(neighbor).append("\n");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Teste de visualização

        GrafoToMatriz grafo = new GrafoToMatriz(5);

        grafo.addEdge(0, 1);
        grafo.addEdge(0, 4);
        grafo.addEdge(1, 2);
        grafo.addEdge(1, 3);
        grafo.addEdge(1, 4);
        grafo.addEdge(2, 3);
        grafo.addEdge(3, 4);

        System.out.println(grafo);

        int[][] matrix = grafo.toAdjacencyMatrix();
        System.out.println("Matriz de Adjacência:");
        printMatrix(matrix);
    }
}
