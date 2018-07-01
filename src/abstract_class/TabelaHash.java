package abstract_class;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TabelaHash {
	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		TabelaHash ha = new TabelaHash((Integer.parseInt(sc.nextLine())));
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

	

	ArrayList<Pair> table;
	int capacity;
	int elements;

	public TabelaHash(int capacity) {
		this.table = new ArrayList<>(capacity);
		this.capacity = capacity;
		this.elements = 0;
		startTable();
	}

	private void startTable() {
		for (int i = 0; i < this.capacity; i++) {
			this.table.add(i, null);
		}

	}

	public int hash(int key, int i) {
		return ((key % this.capacity) + i) % this.capacity;
	}

	public String put(int key, String value) {
		Pair pair = new Pair(key, value);
		int  i = 0;
		while(i < this.capacity) {
			if(this.table.get(hash(key, i)) == null) {
				this.table.set(hash(key, i), pair);
				this.elements++;
				break;
			}else {
				if(this.table.get(hash(key, i)).getKey() == key) {
					this.table.set(hash(key, i), pair);
					break;
				
					
				}
			}
			i++;
		}
		
		return pairs();
	}

	public String remove(int key) {
		int i = 0;
		while(i < this.capacity) {
			int hashe = hash(key, i);
			if(this.table.get(hashe) != null && this.table.get(hashe).getKey() == key) {
				this.table.set(hashe, null);
				this.elements--;
			}
			i++;
		}

		return pairs();
	}

	public String keys() {
		int[] keys = new int[this.elements];
		int k = 0;
		if(this.elements > 0) {
		for (Pair i : this.table) {
			if (i != null) {
				keys[k] = i.getKey();
				k++;
			}
		}
		}

		Arrays.sort(keys);
		return Arrays.toString(keys);
	}

	public String values() {
		String[] values = new String[this.elements];
		int k = 0;
		for (Pair pair : this.table) {
			if (pair != null) {
				values[k] = pair.getValue();
				k++;
			}
		}
		Arrays.sort(values);
		return Arrays.toString(values);
	}

	public String pairs() {
		String[] pairs = new String[this.capacity];
		for (int i = 0; i < this.capacity; i++) {
			if (this.table.get(i) != null) {
				pairs[i] = this.table.get(i).toString();
			} else {
				pairs[i] = "null";
			}
		}

		return Arrays.toString(pairs);
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

		private TabelaHash getOuterType() {
			return TabelaHash.this;
		}
	}

}
