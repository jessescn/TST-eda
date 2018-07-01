package recursividade;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort_recursivo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] vetor = converteVetor(sc.nextLine());
		sort(vetor, 1);
		sc.close();
	}
	
	
	public static void sort(int[] vetor, int index) {
		if(index < vetor.length) {
			insertionSort(vetor, index);
			sort(vetor, index + 1);
		}
	}
	
	public static void insertionSort(int[] vetor, int index) {
			int j = index;
			while(j > 0 && vetor[j - 1] > vetor[j]) {
				swap(vetor, j - 1 , j);
				j--;
			}		
		
		System.out.println(Arrays.toString(vetor));
		
	}
	
	private static void swap(int[] vetor, int i, int j) {
		int aux = vetor[i];
		vetor[i] = vetor[j];
		vetor[j] = aux;
	}
	
	private static int[] converteVetor(String vetor) {
		String[] listaAbs = vetor.split(" ");
		int[] lista = new int[listaAbs.length];
		for (int k = 0; k < listaAbs.length; k ++) {
			lista[k] = Integer.parseInt(listaAbs[k]);
		}return lista;
	}

}
