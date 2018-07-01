package abstract_class;

import java.util.Scanner;

public class Pilha {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Pilha pilha = new Pilha(Integer.parseInt(sc.nextLine()));
		String[] entrada;
		do {
			entrada = sc.nextLine().split(" ");
			switch(entrada[0]) {
			case "push":
				if(!pilha.isFull()) {
					pilha.push(Integer.parseInt(entrada[1]));
				}else {
					System.out.println("full");
					
				}
				break;
			case "pop":
				if(!pilha.isEmpty()) {
					pilha.pop();
				}else {
					System.out.println("empty");
					
				}
				break;
			case "peek":
				if(!pilha.isEmpty()) {
					System.out.println(pilha.peek());
				}else {
					System.out.println("empty");
				}
				break;
			case "print":
				if(pilha.isEmpty()) {
					System.out.println("empty");
				}else {
					System.out.println(pilha.print());
				}
				break;
			}
		}while(!entrada[0].equals("end"));
		sc.close();
		
	}

	private int[] pilha;
	private int capacidade;
	private int topo;
	
	public Pilha(int capacidade) {
		this.capacidade = capacidade;
		this.pilha = new int[capacidade];
		this.topo = -1;
	}
	
	public boolean isEmpty() {
		return this.topo == -1;
	}
	
	public boolean isFull() {
		return this.topo == (capacidade - 1);
	}
	
	
	public void push(int valor) {
		topo++;
		this.pilha[this.topo] = valor;
	}
	
	public int peek() {
		return this.pilha[this.topo];
	}
	
	public int pop() {
		int valor = peek();
		topo--;
		return valor;
	}
	
	public String print() {
		String saida = "";
		for(int i = 0; i <= this.topo;i++) {
			saida += this.pilha[i] + " ";
		}
		return saida.trim();
	}

}
