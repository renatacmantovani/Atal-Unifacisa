package br.com.unifacisa.binaryTrees;

public class Node {

	private Node right;
	private Node left;
	private int value;

	// Inicializa o nó
	public Node(int value) {
		this.value = value;
		right = null;
		left = null;
	}

	// Inicializa o nó
	public Node(Node left, int value, Node right) {
		this.value = value;
		this.right = right;
		this.left = left;
	}

	public void setNull() {
		value = 0;
		right = null;
		left = null;
	}

	public int getValue() {
		return this.value;
	}

	public Node getLeft() {
		return this.left;
	}

	public Node getRight() {
		return this.right;
	}

	public void setValue(int _valor) {
		value = _valor;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public void setRight(Node right) {
		this.right = right;
	}

}