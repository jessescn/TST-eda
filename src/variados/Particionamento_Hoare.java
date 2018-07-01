package variados;

import java.util.Arrays;
import java.util.Scanner;

public class Particionamento_Hoare {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] vetor = converteEntrada(sc.nextLine().split(" "));
		quickSort(vetor, 0, vetor.length - 1);
		sc.close();
	}

	public static void quickSort(int[] array, int inicio, int fim) {
		if (array.length > 1 && fim > inicio) {
			int index = hoare(array, inicio, fim);
			if(inicio == 0 && fim == (array.length - 1)) {
				System.out.println(Arrays.toString(array));
		
			}
			quickSort(array, inicio, index);
			quickSort(array, index + 1, fim);

		}

	}

	public static int hoare(int[] array, int inicio, int fim) {
		int pivot = array[inicio];
		int i = inicio - 1;
		int j = fim + 1;
		while (true) {
			do {
				i++;
			} while (array[i] < pivot);

			do {
				j--;
			} while (array[j] > pivot);

			if (i >= j) {
				return j;
			}
			swap(array, i, j);
		}
		
	}

	public static void swap(int[] array, int i, int j) {
		int aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}

	public static int[] converteEntrada(String[] valores) {
		int[] vetor = new int[valores.length];
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = Integer.parseInt(valores[i]);
		}
		return vetor;
	}
}
