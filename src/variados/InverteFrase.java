package variados;

import java.util.Scanner;

public class InverteFrase {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String frase = sc.nextLine();
		InverteFrase inv = new InverteFrase(frase.length());
		inv.splite(frase);
		System.out.println(inv.getPrint());
		sc.close();
	}
	
	
	
	private Pilha pilha;
	
	public InverteFrase(int tamanho) {
		this.pilha = new Pilha(tamanho);
		
	}
	
	public void splite(String frase){
		String palavra = "";
		for(int i = 0; i < frase.length(); i++) {
			if((frase.charAt(i) + "").equals(" ")) {
				pilha.push(palavra);
				palavra = "";
			}else {
				palavra += frase.charAt(i);
			}
		}
		pilha.push(palavra);
	}
	
	public String getPrint() {
		String fraseInvertida = "";
		while(!pilha.isEmpty()) {
			fraseInvertida += pilha.pop() + " ";
		}
		return fraseInvertida.trim();
	}
	
public class Pilha{
	private String[] pilha;
	private int capacidade;
	private int topo;
	
	public Pilha(int capacidade) {
		this.capacidade = capacidade;
		this.pilha = new String[capacidade];
		this.topo = -1;
	}
	
	public boolean isEmpty() {
		return this.topo == -1;
	}
	
	public boolean isFull() {
		return this.topo == (capacidade - 1);
	}
	
	
	public void push(String valor) {
		topo++;
		this.pilha[this.topo] = valor;
	}
	
	public String peek() {
		return this.pilha[this.topo];
	}
	
	public String pop() {
		String valor = peek();
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
}
