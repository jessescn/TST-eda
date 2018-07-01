package variados;

import java.util.Scanner;

class Fila {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String entrada = sc.nextLine();
		int indice = Integer.parseInt(sc.nextLine());
		int[] vetor = converteVetor(entrada);
		System.out.print(furaFila(vetor, indice));
		sc.close();
		
	}
		
	public static String furaFila(int[] vetor, int indice) {
		int control = 0;
		String saida = "";
		for(int i = indice; i < vetor.length; i ++) {
			int aux = vetor[i];
			int indiceSecundario = i;
			while(indiceSecundario > control) {
				vetor[indiceSecundario] = vetor[indiceSecundario - 1];
				indiceSecundario --;
			}vetor[control] = aux;
			control ++;
			saida += retornaSaida(vetor) + "\n";
		}return saida;
	}
	
	
	
	private static String retornaSaida(int[] vetor) {
		String saida = "[";
		for (int i = 0; i < vetor.length; i++) {
			if(i == vetor.length - 1) {
				saida += vetor[i] + "]";
			}else {
				saida += vetor[i] + ", ";
			}
		}return saida;
	}
	
		
	public static int[] converteVetor(String vetor) {
		String[] listaAbs = vetor.split(" ");
		int[] lista = new int[listaAbs.length];
		for (int k = 0; k < listaAbs.length; k ++) {
			lista[k] = Integer.parseInt(listaAbs[k]);
		}return lista;
	}
	
		
}


