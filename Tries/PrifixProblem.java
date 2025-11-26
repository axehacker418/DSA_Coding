import java.util.*;

public class PrifixProblem {

    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;
        int freq;

        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            freq = 1; // when node is first created
        }
    }

    public static Node root = new Node();

    // Insert into Trie
    public static void insert(String word) {
        word = word.toLowerCase(); // normalize
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            } else {
                curr.children[idx].freq++; // count how many times this path appears
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    // Get shortest unique prefix of a word
    public static String getPrefix(String word) {
        word = word.toLowerCase();
        Node curr = root;
        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            curr = curr.children[idx];
            prefix.append(word.charAt(i));

            // Unique prefix found when freq == 1
            if (curr.freq == 1) {
                return prefix.toString();
            }
        }
        // whole word is the prefix (though problem states no word is prefix of another)
        return prefix.toString();
    }

    public static void main(String[] args) {
        String words[] = { "zebra", "dog", "duck", "dove" };

        // Insert all words
        for (String word : words) {
            insert(word);
        }

        System.out.println("Shortest Unique Prefixes:");
        for (String word : words) {
            System.out.println(word + " -> " + getPrefix(word));
        }
    }
}
