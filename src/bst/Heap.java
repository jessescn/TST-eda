package bst;

import java.util.Arrays;
import java.util.Scanner;

public class Heap {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] aux = sc.nextLine().split(" ");
		Integer[] values = new Integer[aux.length];
		for (int i = 0; i < values.length; i++) {
			values[i] = Integer.parseInt(aux[i]);
		}
		Heap h = new Heap(values);
		h.buildHeap(values);
		System.out.println(Arrays.toString(h.getHeap()));
	}

	Integer[] heap;
	int index;

	public Heap(Integer[] heapi) {
		heap = heapi;
		index = heapi.length - 1;
	}

	private Integer[] getHeap() {
		return this.heap;
	}

	private int parent(int i) {
		return (i - 1) / 2;
	}

	private int left(int i) {
		return (i * 2 + 1);
	}

	private int right(int i) {
		return (i * 2 + 1) + 1;
	}

	public boolean isEmpty() {
		return index == -1;
	}

	public int size() {
		return heap.length;
	}

	public void heapify(int position) {
		if (position < this.size() - 1) {
			int max = indexMax(position, left(position), right(position));
			if (heap[max] != heap[position]) {
				int aux = heap[max];
				heap[max] = heap[position];
				heap[position] = aux;
				heapify(max);
			}
		}
	}

	public void buildHeap(Integer[] array) {
		this.heap = array;
		this.index = array.length - 1;
		for (int i = parent(index); i >= 0; i--) {
			this.heapify(i);
		}

	}

	private int indexMax(int pos, int left, int right) {
		int max = pos;
		if (left < this.size()) {
			if (heap[max] < heap[left]) {
				max = left;
			}
		}
		if (right < this.size()) {
			if (heap[max] < heap[right]) {
				max = right;
			}
		}
		return max;
	}
}
