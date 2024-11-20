package br.com.unifacisa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Grafo {

	private int numVertices;
	private List<List<Integer>> adjacencyList;

	public Grafo(int numVertices) {
		this.numVertices = numVertices;
		this.adjacencyList = new ArrayList<>(numVertices);

		for (int i = 0; i < numVertices; i++) {
			this.adjacencyList.add(new LinkedList<>());
		}
	}

	public void addEdge(int v, int w) {
		/*
		 * v = origem
		 * w = destino
		 */
		adjacencyList.get(v).add(w);
		adjacencyList.get(w).add(v); // Como é um grafo não direcionado, adicionamos a ligação inversa também
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

	public static void main(String[] args) {
		Grafo grafo = new Grafo(5);

		grafo.addEdge(0, 1);
		grafo.addEdge(0, 4);
		grafo.addEdge(1, 2);
		grafo.addEdge(1, 3);
		grafo.addEdge(1, 4);
		grafo.addEdge(2, 3);
		grafo.addEdge(3, 4);

		System.out.println(grafo.toString());
	}
}
