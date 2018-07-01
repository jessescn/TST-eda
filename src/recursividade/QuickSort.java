package recursividade;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] valores = converteArray(sc.nextLine().split(" "));
		sort(valores, 0, valores.length - 1);
		sc.close();
		
		
	}
	
	public static void sort(int[] array, int inicio, int fim) {
		if(fim > inicio) {
			int index = quick(array, inicio, fim);
			sort(array, inicio, index - 1);
			sort(array, index + 1, fim);
		}
	}

	
	public static int quick(int[] array, int inicio, int fim) {
		int pivot = array[inicio];
		int wall = inicio;
		
		for(int i = inicio + 1; i <= fim; i++) {
			if(array[i] < pivot) {
				wall++;
				swap(array, i, wall);
			}
		}
		swap(array, wall, inicio);
		System.out.println(converteSaida(array));
		return wall;
	}
	
	public static void swap(int[] vetor, int i, int j) {
		int aux = vetor[i];
		vetor[i] = vetor[j];
		vetor[j] = aux;
	}
	
	public static int[] converteArray(String[] array) {
		int[] saida = new int[array.length];
		for(int i = 0; i < array.length; i++) {
			saida[i] = Integer.parseInt(array[i]);
		}
		return saida;
	}
	
	public static String converteSaida(int[] array) {
		String saida = "";
		for (int i = 0; i < array.length; i++) {
			saida += array[i] + " ";
		}
		return saida.trim();
	}
}
