package br.com.unifacisa.binaryTrees;

public class Binary {

	private Node root = null;

	public Node getRoot() {
		return root;
	}

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

	public void inOrder(Node no) {
		if (no != null) {
			inOrder(no.getLeft());
			System.out.print(no.getValue() + " ");
			inOrder(no.getRight());
		}
	}

	public void preOrder(Node no) {
		if (no != null) {
			System.out.print(no.getValue() + " ");
			preOrder(no.getLeft());
			preOrder(no.getRight());
		}
	}

	public void postOrder(Node no) {
		if (no != null) {
			postOrder(no.getLeft());
			postOrder(no.getRight());
			System.out.print(no.getValue() + " ");
		}
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

		} else if (node.getLeft() != null && node.getRight() != null) // 2
		// filhos
		{
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

}