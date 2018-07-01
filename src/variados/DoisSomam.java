package variados;

import java.util.Scanner;

public class DoisSomam {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String array = sc.nextLine();
		int soma = Integer.parseInt(sc.nextLine());
		String[] listaAbs = array.split(" ");
		int[] lista = new int[listaAbs.length];
		for (int k = 0; k < listaAbs.length; k ++) {
			lista[k] = Integer.parseInt(listaAbs[k]);
		}
		System.out.println(testaSoma(lista, soma));
		sc.close();
	}
	
	
	public static String testaSoma(int[] array, int soma) {
		boolean teste = false;
		int[] valores = new int[2];
		for (int i = 0; i < array.length; i ++) {
			for (int k = i + 1; k < array.length; k ++) {
				if (array[i] + array[k] == soma) {
					teste = true;
					valores[0] = array[i];
					valores[1] = array[k];
				}
			}
		}if(!teste) {
			return "-1";
		}else {
			return valores[0] + " " + valores[1];
		}
	}

}
