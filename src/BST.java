import java.util.Queue;

// BST == Binary Search Tree
public class BST<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value>{

    private Node root;

    private class Node {
        Key key;
        Value value;

        Node left;
        Node right;
        //Node parent;
        int nodesInSubtree; // author calls this int N;


        public Node(Key key, Value value)
        {
            this.key = key;
            this.value = value;
        }


    }

    public BST()
    {
        root = null;
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
     * @param keyToFind
     */
    public Value getIterative(Key keyToFind) {
        Node current = root;

        while(current != null) {
            int cmp = keyToFind.compareTo(current.key);

            if(cmp == 0) {
                return current.value; // found it
            }
            else if (cmp < 0) {
                current = current.left; // keyToFind < current.key
            }
            else {
                current = current.right; // keyToFind > current.key
            }
        }
        return null; // did not find it
    }


    public Value get(Key keyToFind) {
        return get(root, keyToFind); // start recursive search at the root
    }
    private Value get(Node current, Key keyToFind)
    {
        if(current == null) {
            return null;
        }
        int cmp = keyToFind.compareTo(current.key);

        if (cmp < 0){
            return get(current.left, keyToFind);
        }

        else if(cmp > 0) {
            return get(current.right, keyToFind);
        }
        else {
            return current.value;
        }
    }

    /**
     * Returns the number of key-value pairs in the table.
     *
     * @return
     */
    @Override
    public int size() {
        return size(root);
    }

    private int size(Node current) {
        return size(current.left) + size(current.right) + 1;
    }
    /**
     * Returns an iterator that refers to all the keys
     * in the table.
     */
    @Override
    public Iterable<Key> keys() {
        Queue<Key> q = new LinkedQueue<Key>();
        inorder(root, q);
        return q;
    }

    private void inorder(Node current, Queue<Key> q) {
        if (current == null) {
            return;
        }

        inorder(current.left, q);
        q.enqueue(current.key);
        inorder(current.right, q);
    }
}
