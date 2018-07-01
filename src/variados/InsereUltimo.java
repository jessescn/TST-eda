package variados;

import java.util.Arrays;
import java.util.Scanner;

public class InsereUltimo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] entrada = converteVetor(sc.nextLine());
		insereUltimo(entrada);
		sc.close();
	}
	public static void insereUltimo(int[] array) {
		int i = array.length - 1;
		while(i > 0 && array[i] <= array[i - 1]) {
			swap(array, i, i - 1);
			i--;
		}
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
