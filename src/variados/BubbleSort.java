package variados;

import java.util.Scanner;

class BubbleSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] vetor = converteVetor(sc.nextLine());
		bubblePassoAPasso(vetor);
		sc.close();
	}
	
	public static void bubblePassoAPasso(int[] vetor) {
		
		do {
	
			for(int i = 0 ; i < vetor.length - 1; i++) {
				if(vetor[i] > vetor[i + 1]) {
					swap(vetor, i, i + 1);
				}
			}
			
			System.out.println(converteSaida((vetor)));
			
		}while(!ordenado(vetor));
	}
	
	private static boolean ordenado(int[] array) {
		for(int i = 0; i < array.length - 1; i++) {
			if(array[i] > array[i + 1]) {
				return false;
			}
		}
		return true;
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
	
	public static String converteSaida(int[] vetor) {
		String saida = "";
		for(int i = 0; i < vetor.length; i++) {
			saida += vetor[i] + " ";
		}
		return saida.trim();
	}
}