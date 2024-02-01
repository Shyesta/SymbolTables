public class BinarySearchST<Key extends Comparable, Value> implements SymbolTable<Key, Value> {

    // private fields
    private Key[] keys; // array of keys
    private Value[] values; // array of values
    private int size;

    public BinarySearchST(int capacity)
    {
        // capacity is the potential space we will use
        // size is the actual space used
        keys = (Key[])new Object[capacity];
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

    }

    /**
     * Returns the value paired with the given key.
     *
     * @param key
     */
    @Override
    public Value get(Key key) {
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
        return 0;
    }

    /**
     * Returns an iterator that refers to all the keys
     * in the table.
     */
    @Override
    public Iterable<Key> keys() {
        return null;
    }
}
