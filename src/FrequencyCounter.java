import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Refer to p. 372 of the Algorithms book
 */
public class FrequencyCounter {
//    private SymbolTable<String, Integer> table;

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner in = new Scanner(new File("leipzig1M.txt"));
//
//        // create an empty symbol table (map)
//        SymbolTable<String, Integer> table = new BST<>();
//
//        while(in.hasNext()) {
//            String word = in.next();
//
//            // check if word is in the table
//            if (!table.contains(word)) {
//                table.put(word, 1);
//            }
//            else {
//                // word is in the table - update the value
//                table.put(word, table.get(word) + 1);
//            }
//        }
//        // print out the table
//        for (String word : table.keys()) {
//            System.out.println(word + " | " +  table.get(word));
//        }
        alternate();
    }

    public static void alternate() throws FileNotFoundException {
        Scanner in = new Scanner(new File("leipzig1M.txt"));

        // similar code to above, except using Java built-in libraries
        Map<String, Integer> table = new TreeMap<>();
//        Map<String, Integer> table = new HashMap<>();

        while(in.hasNext()) {
            String word = in.next();

            // check if word is in the table
            if (!table.containsKey(word)) {
                table.put(word, 1);
            }
            else {
                // word is in the table - update the value
                table.put(word, table.get(word) + 1);
            }
        }
        // print out the table
        for (String word : table.keySet()) {
            System.out.println(word + " | " +  table.get(word));
        }
    }
}
