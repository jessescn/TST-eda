package variados;

import java.util.Scanner;

public class Mariana_e_os_livros {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] entrada = sc.nextLine().split(",");
		System.out.println(converteSaida(entrada));
		sort(entrada, 1);
		sc.close();
	}
	
	
	
	public static void sort(String[] array, int comeco) {
		if(array.length > 1 && comeco < array.length) {
			insertion(array, comeco);
			sort(array, comeco + 1);
		}
		}
	
	
	public static void insertion(String[] array, int comeco) {
		String livro = array[comeco];
		int i  = comeco - 1;	
		while(i >= 0 && array[i].compareTo(livro) > 0) {
			swap(array, i, i + 1);
			i--;	
		}
		System.out.println(converteSaida(array));
		
	}
	
	public static String converteSaida(String[] valores) {
		String saida = valores[0];
		for (int i = 1; i < valores.length; i++) {
			saida += ", " + valores[i]; 
		}
		return saida;
	}
	
	public static void swap(String[] valores, int i, int j) {
		String aux = valores[i];
		valores[i] = valores[j];
		valores[j] = aux;
	}

}
