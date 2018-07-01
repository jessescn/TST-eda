package variados;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort_passo_a_passo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String valores = sc.nextLine();
		int[] vetor = converteVetor(valores);
		selectionSort(vetor);
		sc.close();
		
	}
	
	public static  void selectionSort(int[] vetor) {
		for(int i  = 0; i < vetor.length; i++) {
			int menor = i;
			boolean trocou = false;
			for(int j = i; j < vetor.length; j++) {
				if(vetor[j] < vetor[menor]) {
					menor = j;
					trocou = true;
					}
			}
			swap(vetor, i, menor);
			if(trocou) {
			System.out.println(Arrays.toString(vetor));
			}
		}
	}
	private static void swap(int[] array, int i, int j) {
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
	
}
