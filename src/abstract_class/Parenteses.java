package abstract_class;

import java.util.Scanner;


public class Parenteses {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Parenteses par = new Parenteses();
		String parenteses = sc.nextLine();
		if(par.testaValidade(parenteses)) {
			System.out.println("S");
		}else{
			System.out.println("N");
		}
		sc.close();
	}
	

	public boolean testaValidade(String parent) {
		int qtdEsquerdos = 0;
		boolean Valido = true;
		int i = 0;
		while(i < parent.length()) {
			if((parent.charAt(i) + "").equals("(")) {
				qtdEsquerdos += 1;
			}else {
				if(qtdEsquerdos > 0) {
					qtdEsquerdos-= 1;
				}else {
					Valido = false;
					break;
				}
			}
			i++;
		}
		if(qtdEsquerdos > 0) {
			Valido = false;
		}
		return Valido;
		
	}

}
