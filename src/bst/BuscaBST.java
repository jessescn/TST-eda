package bst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BuscaBST {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BuscaBST bst = new BuscaBST();
		String[] entrada = sc.nextLine().split(" ");
		for(String i: entrada) {
			bst.insert(Integer.parseInt(i));
		}
		bst.search(Integer.parseInt(sc.nextLine()));
		sc.close();
	}

	Node root;

	public boolean isEmpty() {
		return root == null;
	}

	public void insert(int data) {
		if (isEmpty()) {
			this.root = new Node(data);
		} else {
			insert(data, root);
		}
	}

	private void insert(int data, Node node) {
		if (data < node.getData()) {
			if (node.getLeft() == null) {
				Node newNode = new Node(data);
				node.setLeft(newNode);
				newNode.setParent(node);
			} else {
				insert(data, node.getLeft());
			}
		} else {
			if (node.getRight() == null) {
				Node newNode = new Node(data);
				node.setRight(newNode);
				newNode.setParent(node);
			} else {
				insert(data, node.getRight());
			}
		}
	}

	public Node search(int data) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		if (!isEmpty()) {
			Node n = search(data, this.root, a);
			System.out.println(a);
			return n;
		}
		return null;
	}

	private Node search(int data, Node n, ArrayList<Integer> a) {
		if (n != null) {
			a.add(n.getData());
			if (n.getData() == data) {
				return n;
			} else {
				if (n.getData() > data) {
					search(data, n.getLeft(),a);
				} else {
					search(data, n.getRight(),a);
				}
			}
		}

		return null;
	}

	public void remove(int data) {
		Node node = search(data);
		if (node != null) {
			remove(node);
		}
	}

	private void remove(Node n) {
		if (n.isLeaf()) {
			if (n == this.root) {
				this.root = null;
			} else {
				putLocal(n.getParent(), n, null);
			}
		} else {
			if ((n.getLeft() == null || n.getRight() == null) && n != this.root) {
				if (n.getLeft() == null) {
					putLocal(n.getParent(), n, n.getRight());
				} else {
					putLocal(n.getParent(), n, n.getLeft());
				}
			} else {
				if (n.getLeft() != null) {
					Node elemento = maximum(n.getLeft());
					int data = elemento.getData();
					remove(elemento);
					n.setData(data);
				} else {
					Node elemento = minimum(n.getRight());
					int data = elemento.getData();
					remove(elemento);
					n.setData(data);
				}
			}
		}
	}

	public void putLocal(Node parent, Node node, Node newNode) {
		if (parent.getLeft() == node) {
			parent.setLeft(newNode);
		} else {
			parent.setRight(newNode);
		}
		if (newNode != null) {
			newNode.setParent(parent);
		}
	}

	public Node maximum() {
		return maximum(this.root);
	}

	private Node maximum(Node node) {
		if (node.getRight() == null) {
			return node;
		} else {
			return maximum(node.getRight());
		}
	}

	public Node minimum() {
		return minimum(this.root);
	}

	private Node minimum(Node node) {
		if (node.getLeft() == null) {
			return node;
		} else {
			return minimum(node.getLeft());
		}
	}

	public Node predecessor(int data) {
		Node node = search(data);
		if (node != null) {
			return predecessor(node);
		}
		return null;
	}

	private Node predecessor(Node node) {
		if (node.getLeft() != null) {
			return maximum(node.getLeft());
		} else {
			Node auxA = node;
			Node auxB = node.getParent();
			while (auxB != null && auxA == auxB.getLeft()) {
				auxA = auxB;
				auxB = auxB.getParent();
			}
			return auxB;
		}
	}

	public Node sucessor(int data) {
		Node node = search(data);
		if (node != null) {
			return sucessor(node);
		}
		return null;
	}

	private Node sucessor(Node node) {
		if (node.getRight() != null) {
			return minimum(node.getRight());
		} else {
			Node auxA = node;
			Node auxB = node.getParent();
			while (auxB != null && auxA == auxB.getRight()) {
				auxA = auxB;
				auxB = auxB.getParent();
			}
			return auxB;
		}
	}

	public int height() {
		return height(this.root);
	}

	private int height(Node node) {
		if (node == null)
			return -1;
		else {
			int hleft = height(node.getLeft());
			int hright = height(node.getRight());
			if (hleft < hright) {
				return hright + 1;
			} else {
				return hleft + 1;
			}
		}

	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {
		int result = 0;

		if (node != null) {
			result = 1 + size(node.getLeft()) + size(node.getRight());
		}
		return result;
	}

	class Node {
		Node left;
		Node right;
		Node parent;
		int data;
		boolean isEmpty;

		public Node(int data) {
			this.isEmpty = true;
			this.data = data;
		}

		public boolean isLeaf() {
			return this.left == null && this.right == null;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + data;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (data != other.data)
				return false;
			return true;
		}

		public int getData() {
			return this.data;
		}

		public Node getLeft() {
			return this.left;
		}

		public Node getRight() {
			return this.right;
		}

		public Node getParent() {
			return this.parent;
		}

		public void setLeft(Node n) {
			this.left = n;
		}

		public void setRight(Node n) {
			this.right = n;
		}

		public void setParent(Node n) {
			this.parent = n;
		}

		public void setData(int data) {
			this.data = data;
		}

		private BuscaBST getOuterType() {
			return BuscaBST.this;
		}

	}


}
