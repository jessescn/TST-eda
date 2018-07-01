package abstract_class;

import java.util.Scanner;

public class Fila {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Fila fila = new Fila();
		String[] entrada;
		do {
			entrada = sc.nextLine().split(" ");
			switch(entrada[0]) {
			case "add":
				fila.add(Integer.parseInt(entrada[1]));
				break;
			case "remove":
				if(!fila.isEmpty()) {
					fila.remove();
				}else {
					System.out.println("empty");
					
				}
				break;
			case "element":
				if(!fila.isEmpty()) {
					System.out.println(fila.element());
				}else {
					System.out.println("empty");
				}
				break;
			case "print":
				if(fila.isEmpty()) {
					System.out.println("empty");
				}else {
					System.out.println(fila.print());
				}
				break;
			case "search":
				if(fila.isEmpty()) {
					System.out.println("-1");
				}else {
					System.out.println(fila.search(Integer.parseInt(entrada[1])));
				}
			}
		}while(!entrada[0].equals("end"));
		sc.close();
		
	}
	
	Node head;
	int size;

	
	public Fila() {
		this.head =  null;
		this.size = 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	/*public boolean isFull() {
		return this.size == this.capacidade;
	}*/
	
	public int getSize() {
		return this.size;
	}
	
	public void add(int i) {
		add(i, this.head);
		this.size++;
	}
	private void add(int i, Node node) {
		if(isEmpty()) {
			node = new Node();
			node.setData(i);
			this.head = node;
		}
		else if(node.getNext() == null) {
			Node nodeAux = new Node();
			nodeAux.setData(i);
			nodeAux.setPrevious(node);
			node.setNext(nodeAux);
		}else {
			add(i, node.getNext());
		}
	}
	
	
	
	public void remove() {
		if(this.size > 1) {
		this.head = this.head.getNext();
		this.head.setPrevious(null);
		this.size--;
		}
		else {
			this.head = null;
			this.size--;
		}
		
	}
	
	public String print() {
		return print(this.head).trim();
	}
	
	private String print(Node node) {
		if(node.getNext() == null) {
			return node.getData() + " ";
		}else {
			return node.getData() + " " + print(node.getNext());
		}
	}
	
	public int element() {
		return this.head.getData();
	}
	
	public int search(int i) {
		return search(i, this.head, 0);
	}
	
	private int search(int i, Node node, int currentIndex) {
		if(node.getData() != i && node.getNext() == null) {
			return -1;
		}
		if(node.getData() == i) {
			return currentIndex;
		}else {
			return search(i, node.getNext(), currentIndex + 1);
		}
	}
	
	
	public class Node{
		private Node next;
		private Node previous;
		private int data;
		
		public Node() {
			this.next = null;
			this.previous = null;
		}
		

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getPrevious() {
			return previous;
		}

		public void setPrevious(Node previous) {
			this.previous = previous;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
		
		
		
	}
}
