
// BST == Binary Search Tree
public class RedBlackBST<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value>{

    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private class Node {
        Key key;
        Value value;

        Node left;
        Node right;
        //Node parent;
        int nodesInSubtree; // author calls this int N;
        boolean color; // color of link from parent to this node


        public Node(Key key, Value value)
        {
            this.key = key;
            this.value = value;
        }


    }

    public RedBlackBST()
    {
        root = null;
    }
    /**
     * Put a key-value pair into the table
     *
     * @param key
     * @param value
     */
    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node current, Key key, Value value)
    {
        if(current == null) {
            Node theNewNode = new Node(key, value);
            theNewNode.nodesInSubtree = 1;
            return theNewNode;
        }
        int cmp = key.compareTo(current.key);

        if(cmp < 0 ) {
            current.left = put(current.left, key, value);
        }
        else if (cmp > 0) {
            current.right = put(current.right, key, value);
        }
        else {
            current.value = value;
        }

        // add some code here to check if there are "4-nodes"
        // indicated by a node having both left and right red links
        // and rebalance via rotation

        current.nodesInSubtree = size(current.left) + size(current.right) + 1;
        return current;
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
        // return size(current.left) + size(current.right) + 1;
        if(current == null) {
            return 0;
        }
        else {
            return current.nodesInSubtree;
        }
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

    // helper methods for red-black tree
    private boolean isRed(Node current) {
        return false; // stub
    }

    private Node rotateLeft(Node current) {
        return null; // stub
    }

    private Node rotateRight(Node current) {
        return null; // stub
    }

    private void flipColors(Node current) {

    }
}
