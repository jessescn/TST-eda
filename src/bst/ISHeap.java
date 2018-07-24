package bst;

import java.util.Scanner;

public class ISHeap {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] values = sc.nextLine().split(" ");
		System.out.println(isHeap(values));

	}
	
	public static boolean isHeap(String[] values) {
		boolean isHeap = true;
		for(int i = 1; i < values.length; i++) {
			int value = Integer.parseInt(values[parent(i)]);
			if(value < Integer.parseInt(values[i])){
				isHeap = false;
			}
		}
		return isHeap;
		
	}
	
	public static int parent(int pos) {
		return (pos -1)/2;
	}

}
