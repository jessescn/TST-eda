package variados;

import java.util.Arrays;
import java.util.Scanner;

public class Estrategia_Lomuto {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] entrada = converteVetor(sc.nextLine());
		quickStep(entrada);
		System.out.println(Arrays.toString(entrada));
		sc.close();
	}

	
	public static void quickStep(int[] array) {
		int indexPivot = 0;
		int wall = 0;
		for(int i = 1;i < array.length; i++) {
			if(array[i] < array[indexPivot]) {
				wall++;
				swap(array, wall, i);
				System.out.println(Arrays.toString(array));
			}
		}
		swap(array, 0, wall);
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
		for (int k = 0; k < listaAbs.length; k++) {
			lista[k] = Integer.parseInt(listaAbs[k]);
		}
		return lista;
	}


}
