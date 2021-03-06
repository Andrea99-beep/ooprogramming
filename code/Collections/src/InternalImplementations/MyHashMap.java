package InternalImplementations;

/**
 * Implementation of a simple HashMap 
 * For simplicity, keys and values must be integers
 * @author Nicola Bicocchi
 *
 */
class MyHashMap_HashEntry {
    private int key;
    private int value;

    MyHashMap_HashEntry(int key, int value) {
          this.key = key;
          this.value = value;
    }     

    public int getKey() {
          return key;
    }

    public int getValue() {
          return value;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + key;
		result = prime * result + value;
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
		MyHashMap_HashEntry other = (MyHashMap_HashEntry) obj;
		if (key != other.key)
			return false;
		if (value != other.value)
			return false;
		return true;
	}
}

public class MyHashMap {
	private final static int TABLE_SIZE = 8;
	MyHashMap_HashEntry[] table;

	public MyHashMap() {
		table = new MyHashMap_HashEntry[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE; i++)
			table[i] = null;
	}

	public int get(int key) {
		int hash = (key % TABLE_SIZE);
		while (table[hash] != null && table[hash].getKey() != key)
			hash = (hash + 1) % TABLE_SIZE;
		if (table[hash] == null)
			return -1;
		else
			return table[hash].getValue();
	}

	public void put(int key, int value) {
		int hash = (key % TABLE_SIZE);
		while (table[hash] != null && table[hash].getKey() != key)
			hash = (hash + 1) % TABLE_SIZE;
		table[hash] = new MyHashMap_HashEntry(key, value);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < TABLE_SIZE; i++) {
			try {
				int key = table[i].getKey();
				int value = table[i].getValue();
				int hash = (key % TABLE_SIZE);
				sb.append("bucket " + i + " --> hash=" + hash + " (" + key + ", " + value + ")");
			} catch (NullPointerException e) {
				sb.append("bucket " + i + " --> null");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}