package variados;

import java.util.Arrays;
import java.util.Scanner;

class MoveImpostos {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int[] valores = converteVetor(sc.nextLine().trim());
	System.out.println(Arrays.toString(encontraImpostor(valores)));
	sc.close();
	
	}
	
	public static int[] encontraImpostor(int[] vetor) {
		int impostor = 1;
		while(impostor < vetor.length && vetor[impostor - 1] <= vetor[impostor]) {
			impostor ++; 
		}
		
		while(impostor > 0 && vetor[impostor] < vetor[impostor - 1] ) { 
			swap(vetor, impostor, impostor - 1);
			impostor --;
		}
		return vetor;
	}
	
	private static void swap(int[] vetor, int i, int j) {
		int aux =  vetor[i];
		vetor[i] = vetor[j];
		vetor[j] = aux;
	}
	public static int[] converteVetor(String vetor) {
		String[] listaAbs = vetor.split(" ");
		int[] lista = new int[listaAbs.length];
		for (int k = 0; k < listaAbs.length; k ++) {
			lista[k] = Integer.parseInt(listaAbs[k]);
		}return lista;
	}

}
