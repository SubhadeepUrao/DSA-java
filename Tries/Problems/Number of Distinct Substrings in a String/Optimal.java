class Node {
    Node[] next = new Node[26];
}

class Trie {
    Node root;
    int wordCount;

    Trie() {
        root = new Node();
        wordCount = 0;
    }

    void insert(String word) {
        int i = 0;
        int N = word.length();
        Node curr = root;
        while (i < N) {
            int ind = word.charAt(i++) - 'a';
            if (curr.next[ind] == null) {
                curr.next[ind] = new Node();
                ++wordCount;
            }
            curr = curr.next[ind];
        }
    }
}

class Solution {
    // When you insert a suffix into the Trie, any overlapping parts with previously
    // inserted suffixes reuse existing nodes. This ensures that each node
    // represents a unique substring.
    public static int countDistinctSubstrings(String s) {
        Trie t = new Trie();

        int N = s.length();
        for (int i = 0; i < N; ++i) {
            t.insert(s.substring(i));
        }
        return t.wordCount + 1; // "" was not accounted
    }
}