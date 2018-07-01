package bst;

import java.util.Scanner;

public class AlturaBST {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AlturaBST bst = new AlturaBST();
		String[] ent = sc.nextLine().split(" ");
		for(String i : ent) {
			bst.insert(Integer.parseInt(i));
		}
		System.out.println(bst.height());
		sc.close();
		
	}
	Node root;
	
	public AlturaBST() {
		Node node = new Node();
		this.root = node;
	}
	
	public boolean isEmpty() {
		return this.root.isEmpty();
	}
	
	public int height() {
		return height(this.root);
	}

	private int height(Node node) {
		if (node.isEmpty())
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
	
	public void insert(int data) {
		if(isEmpty()) {
			Node node = new Node();
			node.setAll(new Node(), new Node(), data);
			this.root = node;
		}else {
			insert(data, this.root);
		}
		
	}
	
	private void insert(int data, Node n) {
		Node newNode = new Node();
		if(data < n.getData()) {
			if(n.getLeft().isEmpty()) {
				newNode.setAll(new Node(), new Node(), data);
				newNode.setParent(n);
				n.setLeft(newNode);
			}else {
				insert(data, n.getLeft());
			}
		}else {
			if(n.getRight().isEmpty()) {
				newNode.setAll(new Node(), new Node(), data);
				newNode.setParent(n);
				n.setRight(newNode);
			}else {
				insert(data, n.getRight());
			}
		}
	
	}

	public Node search(int data) {
		return search(data, root);
	}
	
	private Node search(int data, Node n) {
		if(n.getData() == data) {
			return n;
		}else {
			if(data < n.getData()) {
				search(data, n.getRight());
			}else {
				search(data, n.getLeft());
			}
		}
		return null;
	}
	
	
	public Node maximum() {
		return maximum(this.root);
	}
	
	private Node maximum(Node n) {
		if(n.getRight().isEmpty()) {
			return n;
		}else {
			return maximum(n.getRight());
		}
	}
 
	public Node minimum() {
		return minimum(this.root);
	}
	
	private Node minimum(Node n) {
		if(n.getLeft().isEmpty()) {
			return n;
		}else {
			return minimum(n.getLeft());
		}
		
	}
	
	public void remove(int data) {
		Node n = search(data);
		if(n != null) {
			remove(n);
		}
	}

	private void remove(Node n) {
		if(n.isLeaf()) {
			if(!n.equals(root)) {
				putLocal(n.getParent(), n, new Node());
			}else {
				this.root = new Node();
			}
		}else {
			if((n.getLeft().isEmpty() || n.getRight().isEmpty()) && n != root) {
				if(n.getLeft().isEmpty()) {
					putLocal(n.getParent(), n, n.getRight());
				}else {
					putLocal(n.getParent(), n, n.getLeft());
				}
			}else {
				if (!n.getLeft().isEmpty()) {
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
		if(parent.getLeft() == node) {
			parent.setLeft(newNode);
			newNode.setParent(parent);
		}else {
			parent.setRight(newNode);
			newNode.setParent(parent);
		}
	}
	
	public Node predecessor(int data) {
		Node node = search(data);
		if(node != null) {
			return predecessor(node);
		}
		return null;
	}
	
	
	private Node predecessor(Node node) {
		if(!node.getLeft().isEmpty()) {
			return maximum(node.getLeft());
		}else {
			Node auxA = node;
			Node auxB = node.getParent();
			while(auxB != null && auxA == auxB.getLeft()){
				auxA = auxB;
				auxB = auxB.getParent();
			}
			return auxB;
		}
	}


	public Node sucessor(int element) {
		Node node = search(element);
		if (!node.isEmpty()) {
			return this.sucessor(node);
		}
		return null;

	}

	private Node sucessor(Node node) {
		if(!node.getRight().isEmpty()) {
			return this.minimum(node.getRight());
		}else{
			Node auxA = node;
			Node auxB = node.getParent();
			while(auxB != null && auxA == auxB.getRight()) {
				auxA = auxB;
				auxB = auxB.getParent();
			}
			return auxB;
		}
	}
	
	class Node{
		private Node left;
		private Node right;
		private Node parent;
		

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (data != other.data)
				return false;
			return true;
		}
		
		private int data;
		private boolean Empty;
		
		public Node() {
			this.Empty = true;
		}
		
		public void setAll(Node left, Node right, int data) {
			this.left = left;
			this.right = right;
			this.data = data;
			this.Empty = false;
		}
		
		public boolean isEmpty() {
			return this.Empty;
		}
		public boolean isLeaf() {
			return this.left.isEmpty() && this.right.isEmpty(); 
		}
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
		public Node getParent() {
			return parent;
		}
		public void setParent(Node parent) {
			this.parent = parent;
		}
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.Empty = false;
			this.data = data;
		}

	}


}
