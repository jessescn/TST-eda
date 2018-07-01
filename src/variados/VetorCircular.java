package variados;

import java.util.Scanner;

class VetorCircular {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String array = sc.nextLine();
		int quant = Integer.parseInt(sc.nextLine());
		int[] vetor =  converteVetor(array);
		System.out.println(circulador(vetor, quant));
		sc.close();
	}
	
	
	
	public static String circulador(int[] array, int quant) {
		int control = 0;
		int contador = 0;
		int[] vetor = new int[quant];
		while(control != quant) {
			if (contador == array.length - 1) {
				vetor[control] = array[contador];
				control ++;
				contador = 0;
			}else {
			vetor[control] = array[contador];
			control ++;
			contador ++;
			}
		}
		String saida = "";
		for(int k : vetor) {
			saida +=  k + " " ;
		} return saida.trim();
	}
	
	public static int[] converteVetor(String vetor) {
		String[] listaAbs = vetor.split(" ");
		int[] lista = new int[listaAbs.length];
		for (int k = 0; k < listaAbs.length; k ++) {
			lista[k] = Integer.parseInt(listaAbs[k]);
		}return lista;
	}
}
