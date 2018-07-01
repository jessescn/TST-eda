package abstract_class;

import java.util.Scanner;

public class Fila2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Fila2 fila = new Fila2(Integer.parseInt(sc.nextLine()));
		String[] entrada;
		do {
			entrada = sc.nextLine().split(" ");
			switch(entrada[0]) {
			case "add":
				if(!fila.isFull()) {
					fila.add(Integer.parseInt(entrada[1]));
				}else {
					System.out.println("full");
					
				}
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
			}
		}while(!entrada[0].equals("end"));
		sc.close();
		
	}

	int[] fila;
	int capacidade;
	int head;

	public Fila2(int capacidade) {
		this.fila = new int[capacidade];
		this.head = -1;

	}

	public int element() {
		return this.fila[0];
	}

	public void add(int n) {

		this.head++;
		this.fila[this.head] = n;

	}

	public void remove() {
		pusher();
		this.head --;
	}

	public String print() {
		String saida = "";
		for (int i = 0; i <= this.head; i++) {
			saida += this.fila[i] + " ";
		}
		return saida.trim();
	}

	private void pusher() {
		for (int i = 1; i < this.fila.length; i++) {
			this.fila[i - 1] = this.fila[i];
		}
	}

	public boolean isFull() {
		return this.head == this.fila.length - 1;
	}

	public boolean isEmpty() {
		return this.head == -1;
	}

}
