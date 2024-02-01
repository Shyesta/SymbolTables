public class SequentialSearchST<Key, Value> implements SymbolTable<Key, Value>{

    private Node head;
    private int size;
    public class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next)
        {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public SequentialSearchST()
    {
        head = null;
        size = 0;
    }

    /**
     * Put a key-value pair into the table
     *
     * @param key
     * @param val
     */
    @Override
    public void put(Key key, Value val) {
        // if the key is not in the list, put it up front at the head
        // but if key is already in the list, replace the value in that node

        Node current = head;
        while(current != null)
        {
            if(key.equals(current.key))
            {
                // we found the key!
                current.value = val;
                return;
            }
            current = current.next;
        }
        // the key does not exist, add this node to the front
        head = new Node(key, val, head);
        size++;
//        if(!this.contains(key))
//        {
//
//        }
    }

    /**
     * Returns the value paired with the given key.
     *
     * @param key
     */
    @Override
    public Value get(Key key) {
        Node current = head;
        while(current != null)
        {
            if(key.equals(current.key))
            {
                return current.value;
            }
            current = current.next;
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
        return null;
    }
}