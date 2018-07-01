package abstract_class;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HashChainning {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashChainning ha = new HashChainning((Integer.parseInt(sc.nextLine())));
		String[] entrada;
		do {
			entrada = sc.nextLine().split(" ");
			switch(entrada[0]) {
			case "put":
				System.out.println(ha.put(Integer.parseInt(entrada[1]), entrada[2]));
				break;
			case "remove":
				System.out.println(ha.remove(Integer.parseInt(entrada[1])));
				break;
			case "keys":
				System.out.println(ha.keys());
				break;
			case "values":
				System.out.println(ha.values());
				break;
			}
		}while(!entrada[0].equals("end"));
		sc.close();
	}

	ArrayList<ArrayList<Pair>> table;
	int capacity;
	int quant;

	public HashChainning(int capacity) {
		this.table = new ArrayList<ArrayList<Pair>>(capacity);
		this.capacity = capacity;
		this.quant = 0;
		startTable();
	}

	public int getQuant() {
		return this.quant;
	}

	public int hash(int key) {
		return key % this.capacity;
	}

	private void startTable() {
		for (int i = 0; i < this.capacity; i++) {
			ArrayList<Pair> array = new ArrayList<>();
			this.table.add(array);
		}
	}

	public String put(int key, String value) {
		int h = hash(key);
		Pair pair = new Pair(key, value);
		if (!this.table.get(h).contains(pair)) {
			this.table.get(h).add(pair);
			this.quant++;
		} else {
			ArrayList<Pair> array = this.table.get(h);
			int index = array.indexOf(pair);
			if (!array.get(index).getValue().equals(pair.getValue())) {
				array.get(index).setValue(value);
			}
		}
		return Arrays.toString(pairs());
	}

	public String remove(int key) {
		int h = hash(key);
		Pair aux = new Pair(key, null);
		if (this.table.get(h).contains(aux)) {
			this.table.get(h).remove(aux);
			this.quant--;
		}
		return Arrays.toString(pairs());
	}

	public String keys() {
		int[] keys = new int[this.quant];
		int k = 0;
		for (int i = 0; i < this.capacity; i++) {
			ArrayList<Pair> array = this.table.get(i);
			if (array.size() > 0) {
				for (Pair j : array) {
					keys[k] = j.getKey();
					k++;
				}
			}
		}
		Arrays.sort(keys);
		return Arrays.toString(keys);
	}

	public String values() {
		String[] values = new String[this.quant];
		int k = 0;
		for (int i = 0; i < this.capacity; i++) {
			ArrayList<Pair> array = this.table.get(i);
			if (array.size() > 0) {
				for (Pair j : array) {
					values[k] = j.getValue();
					k++;
				}
			}
		}
		Arrays.sort(values);
		return Arrays.toString(values);
	}

	public String[] pairs() {
		String[] pairs = new String[this.capacity];
		for (int i = 0; i < this.capacity; i++) {
			ArrayList<Pair> array = this.table.get(i);
			String[] arrayAux = new String[array.size()];
			if (array.size() > 0) {
				for (int j = 0; j < array.size(); j++) {
					arrayAux[j] = array.get(j).toString();
				}
				pairs[i] = Arrays.toString(arrayAux);
				
			} else {
				pairs[i] = "[]";
				
			}
		}
		
		return pairs;
	}

	class Pair {
		int key;
		String value;

		public Pair(int key, String value) {
			this.key = key;
			this.value = value;
		}

		public int getKey() {
			return this.key;
		}

		public String toString() {
			return "<" + this.key + ", " + this.value + ">";
		}

		public String getValue() {
			return this.value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + key;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (key != other.key)
				return false;
			return true;
		}

		private HashChainning getOuterType() {
			return HashChainning.this;
		}

	}
}
