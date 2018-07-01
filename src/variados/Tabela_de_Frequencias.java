package variados;

import java.util.Scanner;

public class Tabela_de_Frequencias {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] entrada = converteVetor(sc.nextLine());
		frequencia(entrada);
		sc.close();

	}

	public static void frequencia(int[] array) {
		int[] frequencia = new int[getMaior(array) + 1];

		// contando a quantidade de cada valor
		for (int i = 0; i < array.length; i++) {
			frequencia[array[i]]++;
		}

		// formando as duplas de valores com suas respectivas frequencias

		String print = "";
		for (int i = 0; i < array.length; i++) {
			if(frequencia[array[i]] != 0) {
			print += array[i] + "," + frequencia[array[i]] + " ";
			frequencia[array[i]] = 0;
			}
		}
		System.out.println(print.trim());
	}

	public static int getMaior(int[] array) {
		int maior = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > maior) {
				maior = array[i];
			}
		}
		return maior;
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
