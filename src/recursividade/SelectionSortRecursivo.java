package recursividade;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSortRecursivo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] entrada = converteVetor(sc.nextLine());
		sort(entrada, 0);
		sc.close();
	}
	
	public static void sort(int[] array, int index) {
		if(index < array.length - 1) {
			selectionSort(array, index);
			sort(array, index + 1);
		}
	}
	
	
	public static void selectionSort(int[] array, int index) {
		int menor = index;
		
		//encontra menor
		for (int i = index + 1; i < array.length; i++) {
			if(array[i] < array[menor]) {
				menor = i;
			}
		}
		
		swap(array, index, menor);
		
		System.out.println(Arrays.toString(array));
		
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

}
