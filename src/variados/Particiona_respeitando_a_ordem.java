package variados;

import java.util.Arrays;
import java.util.Scanner;

public class Particiona_respeitando_a_ordem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] entrada = converteVetor(sc.nextLine());
		quick(entrada);
		sc.close();

	}

	public static void quick(int[] array) {
		if (array.length > 1) {
			int pivot = array[0];
			int wall = 0;
			for (int i = 1; i < array.length; i++) {
				if (array[i] <= pivot) {
					//System.out.println(array[i]);
					wall++;
					swapCostas(array,wall, i);
				}
			}
			swapFrente(array, 0, wall);
			System.out.println(Arrays.toString(array));
		}
	}
	
	public static void swapFrente(int[] array, int i, int j) {
		while (i < j) {
			swap(array,i, i + 1);
			i++;
		}
	}

	public static void swapCostas(int[] array, int i, int j) {
		while (i < j) {
			swap(array, j - 1, j);
			j--;
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
		for (int k = 0; k < listaAbs.length; k++) {
			lista[k] = Integer.parseInt(listaAbs[k]);
		}
		return lista;
	}

}
