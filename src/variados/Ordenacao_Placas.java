package variados;


import java.util.Scanner;

public class Ordenacao_Placas {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] valores = sc.nextLine().split(",");
		radix(valores, 9999);
		sc.close();
	}
	
	public static void radix(String[] vetor, int max) {
		for(int i = 1 ; max/i > 0 ; i *= 10) {
			counting(vetor, i);
		}
		System.out.println(ConverteSaida(vetor));
		
	}
	
	public static void counting(String[] array, int exp) {
		int[] contador = new int[10];
		int i;
		
		for(i = 0; i < array.length; i++) {
			contador[(rN(array[i])/exp) % 10]++;
		}
		
		
		for(i = 1; i < contador.length; i++) {
			contador[i] += contador[i - 1];
		}
		
		String[] arrayCopia = new String[array.length];
		
		for(i = array.length - 1; i >= 0; i--) {
			contador[(rN(array[i])/exp) % 10]--;
			int index = contador[(rN(array[i])/exp) % 10];
			arrayCopia[index] = array[i];
		}
		
		for(i = 0; i < arrayCopia.length;i++) {
			array[i] = arrayCopia[i];
		}
		
		
	}
	public static String ConverteSaida(String[] valores) {
		String saida = "" + valores[0];
		for(int i = 1; i < valores.length; i++) {
			saida += ", " + valores[i];
		}
		return saida;
	}
	
	public static int rN(String placa) {
		String[] subvalores = placa.split("-");
		return Integer.parseInt(subvalores[1]);
	}
	
	
}
