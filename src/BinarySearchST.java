public class BinarySearchST<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value> {

    // private fields
    private Key[] keys; // array of keys
    private Value[] values; // array of values
    private int size;

    public BinarySearchST(int capacity)
    {
        // capacity is the potential space we will use
        // size is the actual space used
        keys = (Key[])new Comparable[capacity];
        values = (Value[])new Object[capacity];


    }

    private int rank(Key key) {
        // returns the index of where the key is located
        int low = 0; // low index
        int high = size -1; // high index

        while(low <= high)
        {
            int mid = low + (high - low) / 2; // find halfway
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) // if (key < keys[mid])
            {
                high = mid -1;
            }
            else if (cmp > 0) // else if (key > keys[mid])
            {
                low = mid + 1;
            }
            else { // else we know key == keys[mid]
                return mid;
            }
        }
        return low;
    }
    /**
     * Put a key-value pair into the table
     *
     * @param key
     * @param val
     */
    @Override
    public void put(Key key, Value val) {
        int i = rank(key);

        if (i < size && key.compareTo(keys[i]) == 0) {
            // we found the key in the keys array
            // so that means a value already exists, overwrite the existing value
            values[i] = val;
            return;
        }

        // key is not in the array
        for (int j = size; j > i; j--)
        {
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }

        // once we get here, shifting is done and there's a spot
        keys[i] = key;
        values[i] = val;
        size++;
    }

    /**
     * Returns the value paired with the given key.
     *
     * @param key
     */
    @Override
    public Value get(Key key) {
        if (isEmpty())
        {
            return null;
        }

        int i = rank(key);
        // rank() is going to give us the index of where the key is located
        // OR is going to give us the index of where the key should go if it's not there

        if (key.equals(keys[i]))
        {
            return values[i];
        }
        return null;
    }


    /**
     * Remove key (and it's value) from the table.
     *
     * @param key
     */
    @Override
    public void delete(Key key) {
        SymbolTable.super.delete(key);
    }

    /**
     * Returns true if there is a value paired with a key.
     *
     * @param key
     */
    @Override
    public boolean contains(Key key) {
        return SymbolTable.super.contains(key);
    }

    /**
     * Returns true if the table is empty.
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return SymbolTable.super.isEmpty();
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
        Queue<Key> q = new LinkedQueue<>();
        // walk through keys array and enqueue all the keys
        for (int i = 0; i < size; i++) {
            q.enqueue(keys[i]);
        }
        return q;
    }
}
