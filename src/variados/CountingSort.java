package variados;


import java.util.Scanner;

public class CountingSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] entrada = converteArray(sc.nextLine().split(" "));
		int maior = Integer.parseInt(sc.nextLine());
		counting(entrada, maior);
		System.out.println(converteSaida(entrada));
		sc.close();
	}
	
	public static void counting(int[] array, int maior) {
		int[] contagem = new int[maior + 1];
		int i;
		
		// contagem dos valores
		for(i = 0; i < array.length;i++) {
			contagem[array[i]]++;
			System.out.println(converteSaida(contagem));
		}
		
		//soma cumulativa
		for(i = 1; i < contagem.length; i++) {
			contagem[i] += contagem[i - 1];
		}
		
		System.out.println("Cumulativa do vetor de contagem - " + converteSaida(contagem));
		
		int[] copia = new int[array.length];
		
		// organiza de forma ordenada os valores no array copia
		for (i = array.length - 1; i >= 0; i--) {
			contagem[array[i]]--;
			int index = contagem[array[i]];
			copia[index] = array[i];
		}
		
		for(i = 0; i < array.length; i++) {
			array[i] = copia[i];
		}
		System.out.println(converteSaida(contagem));
	}
	
	public static String converteSaida(int[] array) {
		String saida = "";
		for (int i = 0; i < array.length; i++) {
			saida += array[i] + " ";
		}
		return saida.trim();
	}

	public static int[] converteArray(String[] array) {
		int[] saida = new int[array.length];
		for(int i = 0; i < array.length; i++) {
			saida[i] = Integer.parseInt(array[i]);
		}
		return saida;
	}

}
