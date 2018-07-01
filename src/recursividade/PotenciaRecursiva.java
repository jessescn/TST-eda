package recursividade;

import java.util.Scanner;

    class PotenciaRecu {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int base = Integer.parseInt(sc.nextLine());
		int expoente = Integer.parseInt(sc.nextLine());
		System.out.println(recursivoExpoente(base, expoente));
		sc.close();
	}
		public static int recursivoExpoente(int b, int expo) {
		if(expo == 0) {
			return 1;
		}else {
			return b * recursivoExpoente(b, expo - 1);
		}
	
	}
}