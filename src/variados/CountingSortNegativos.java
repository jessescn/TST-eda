package variados;

import java.util.Arrays;
import java.util.Scanner;

public class CountingSortNegativos {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] entrada = converteVetor(sc.nextLine());
		int maior = Integer.parseInt(sc.nextLine());
		int menor = Integer.parseInt(sc.nextLine());
		Counting(entrada, menor, maior);
		sc.close();
	}
	
	public static void Counting(int[] array, int menor, int maior) {
		int k = maior - menor;
		int[] contador = new int[k + 1];
		
		Arrays.fill(contador, 0);
		
		// mapeamento dos valores do array no array contador, printando cada incrementacao
		for(int i = 0; i < array.length; i++) {
			contador[array[i] - menor] ++;
			System.out.println(Arrays.toString(contador));
		}
		
		// soma cumulativa
		for(int i = 1; i < contador.length; i++) {
			contador[i] += contador[i - 1];
		}
		
		// Printando o array depois da soma cumulativa
		System.out.println("Cumulativa do vetor de contagem - " + Arrays.toString(contador));
		
		int[] arrayCopia = new int[array.length];
		
		for(int i = array.length - 1; i >= 0; i--) {
			contador[array[i] - menor]--;
			int index = contador[array[i] - menor];
			arrayCopia[index] = array[i];
		}
		
		System.out.println(Arrays.toString(contador));
				
		copiaArray(array, arrayCopia);
		System.out.println(Arrays.toString(array));
		
		}
	
	public static void copiaArray(int[] original, int[] ordenado) {
		for(int i = 0; i < ordenado.length; i++) {
			original[i] = ordenado[i];
		}
	}
	
	public static int[] converteVetor(String vetor) {
		String[] listaAbs = vetor.split(" ");
		int[] lista = new int[listaAbs.length];
		for (int k = 0; k < listaAbs.length; k ++) {
			lista[k] = Integer.parseInt(listaAbs[k]);
		}return lista;
	}
	
		
		

}
