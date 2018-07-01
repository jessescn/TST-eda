package variados;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort_passo_a_passo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] valores = converteVetor(sc.nextLine());
		System.out.println(Arrays.toString(valores));
		sort(valores, 0, valores.length - 1);
		sc.close();
	}
	
	public static void sort(int[] vetor,int inicio, int fim) {
		if(fim > inicio){
		int meio = (fim + inicio)/2;
		System.out.println(Arrays.toString(parteArray(vetor, inicio, meio)));
		sort(vetor,inicio, meio);
		System.out.println(Arrays.toString(parteArray(vetor, meio + 1, fim)));
		sort(vetor, meio + 1, fim);
		merge(vetor, inicio, meio, fim);
		}	
	}

	private static void merge(int[] array, int inicio, int meio, int fim) {
		int[] arrayCopia = Arrays.copyOf(array, array.length);
		int i = inicio;
		int j = meio + 1;
		int k = inicio;
		while(i <= meio && j <= fim) {
			if(arrayCopia[i] < arrayCopia[j]) {
				array[k] = arrayCopia[i];
				i++;
			}else {
				array[k] = arrayCopia[j];
				j++;
			}
			k++;
		}
		
		while(i <= meio) {
			array[k] = arrayCopia[i];
			i++;
			k++;
		}
		
		while(j <= fim) {
			array[k] = arrayCopia[j];
			j++;
			k++;			
		}
		
		
		System.out.println(Arrays.toString(parteArray(array, inicio, fim)));
		
	}
	
	public static int[] parteArray(int[] array, int i, int j) {
		int[] parteArray = new int[j - i + 1];
		
		for(int l = i; l <= j; l++) {
			parteArray[l - i] = array[l];
		}
		return parteArray;
	}

	public static int[] converteVetor(String vetor) {
		String[] listaAbs = vetor.split(" ");
		int[] lista = new int[listaAbs.length];
		for (int k = 0; k < listaAbs.length; k ++) {
			lista[k] = Integer.parseInt(listaAbs[k]);
		}return lista;
	}
}
