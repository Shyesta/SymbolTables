public class SeparateChainingHashST<Key, Value> implements SymbolTable<Key, Value>{
    // private fields
    // array of linked lists
    private SequentialSearchST<Key, Value>[] table;
    private int tableSize; // size of the array
    private int size; // number of actual keys in the table

    public SeparateChainingHashST(int tableSize) {
        this.tableSize = tableSize;
        size = 0;
        // creates an array (each element is default initialized to null)
        table = new SequentialSearchST[tableSize];

        // loop through array, replace null with an empty linked list object
        for (int i = 0; i < tableSize; i++) {
            table[i] = new SequentialSearchST<>();
        }
    }

    public SeparateChainingHashST() {
        this(997);
    }

    // private helper method - the hash function
    private int hash(Key key) {
        // take a key and generate an index number
        // simple way: key.hashCode() % tableSize
        return (key.hashCode() & 0x7fffffff) % tableSize;
    }

    /**
     * Put a key-value pair into the table
     *
     * @param key
     * @param val
     */
    @Override
    public void put(Key key, Value val) {
        // if the table doesn't contain the key, bump the size up
        if(!table[hash(key)].contains(key)) {
            size++;
        }
        // add the new key, replace the value associated with the key if already there
        table[hash(key)].put(key, val);
    }

    /**
     * Returns the value paired with the given key.
     *
     * @param key
     */
    @Override
    public Value get(Key key) {
        return table[hash(key)].get(key);
    }

    /**
     * Returns the number of key-value pairs in the table.
     *
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator that refers to all the keys
     * in the table.
     */
    @Override
    public Iterable<Key> keys() {
        Queue<Key> q = new LinkedQueue<Key>();

        for (int i = 0; i < tableSize; i++) {
            for (Key singleKey : table[i].keys()) {
                q.enqueue(singleKey);
            }
        }
        return q;
    }
}
