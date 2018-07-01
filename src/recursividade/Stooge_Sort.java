package recursividade;

import java.util.Arrays;
import java.util.Scanner;

public class Stooge_Sort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] vetor = converteVetor(sc.nextLine());
		sort(vetor);
		sc.close();
	}
	
	
	
	public static void sort(int[] vetor) {
		stooge(vetor, 0, vetor.length - 1);
		System.out.println(converteSaida(vetor));
	}
	
	public static void stooge(int[] vetor, int inicio, int fim) {
		if(vetor[inicio] > vetor[fim]) {
			swap(vetor, inicio, fim);
		}
		if(fim - inicio > 1) {
			int terco = (fim - inicio + 1)/3;
			stooge(vetor, inicio, fim - terco);
			stooge(vetor, inicio + terco, fim);
			stooge(vetor, inicio, fim - terco);
		}
	}
	
	public static void swap(int[] array, int i, int j) {
		int aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}
	
	public static int[] converteVetor(String vetor) {
		String[] listaAbs = vetor.split(" ");
		int[] lista = new int[listaAbs.length];
		for (int k = 0; k < listaAbs.length; k ++) {
			lista[k] = Integer.parseInt(listaAbs[k]);
		}return lista;
	}
	
	public static String converteSaida(int[] vetor) {
		String saida = "";
		for(int i = 0; i < vetor.length; i++) {
			saida += vetor[i] + " ";
		}
		return saida.trim();
	}

}
