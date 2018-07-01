package variados;

import java.util.Scanner;

public class ElementoSobrando {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String entrada1 = sc.nextLine();
		String entrada2 = sc.nextLine();
		int[] vetor1 = converteVetor(entrada1);
		int[] vetor2 = converteVetor(entrada2);
		System.out.println(identificaElemento(vetor1, vetor2));
		sc.close();
	}
	
	
	public static int identificaElemento(int[] array1, int[] array2) {
		int deFora = 0;
		for (int i = 0; i < array2.length; i ++) {
			boolean existe = false;
			for(int k = 0; k < array1.length; k ++) {
				if (array2[i] == array1[k]) {
					existe = true;
					break;
				}
			}if(!existe) {
				deFora = array2[i];
			}
		}return deFora;
	}
	
	public static int[] converteVetor(String vetor) {
		String[] listaAbs = vetor.split(" ");
		int[] lista = new int[listaAbs.length];
		for (int k = 0; k < listaAbs.length; k ++) {
			lista[k] = Integer.parseInt(listaAbs[k]);
		}return lista;
	}

}
