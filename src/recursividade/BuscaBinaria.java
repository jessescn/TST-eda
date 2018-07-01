package recursividade;

import java.util.Scanner;

public class BuscaBinaria {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String vetor = sc.nextLine();
		int[] array = converteVetor(vetor);
		int valor = Integer.parseInt(sc.nextLine());
		String[] indices = buscaBinaria(array, valor, 0, array.length).split(" ");
		for(String k : indices) {
			System.out.println(k);
		}
		sc.close();
	}

	
	public static String buscaBinaria(int[] array, int valor, int comeco, int fim) {
		int meio = (fim - comeco)/2;
		String indices = "";
		if (array[meio] == valor) {
			return meio + " ";
		}if(meio == 1 && array[meio] != valor) {
			return "-1";
		}else{
			if(array[meio] > valor) {
				return indices + buscaBinaria(array, valor, comeco, meio);
			}if(array[meio] < valor) {
				return indices + buscaBinaria(array, valor, meio, fim);
			}
		} return indices;
	}
	
	public static int[] converteVetor(String vetor) {
		String[] listaAbs = vetor.split(" ");
		int[] lista = new int[listaAbs.length];
		for (int k = 0; k < listaAbs.length; k ++) {
			lista[k] = Integer.parseInt(listaAbs[k]);
		}return lista;
	}
}
