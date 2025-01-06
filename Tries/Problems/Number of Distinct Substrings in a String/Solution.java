class Node {
    Node[] next = new Node[26];
    boolean word;
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
            if (curr.next[ind] == null)
                curr.next[ind] = new Node();
            curr = curr.next[ind];
        }
        if (!curr.word) {
            curr.word = true;
            ++wordCount;
        }
    }
}

class Solution {
    public static int countDistinctSubstrings(String s) {
        Trie t = new Trie();

        int N = s.length();
        for (int i = 0; i < N; ++i) {
            for (int j = i + 1; j <= N; ++j) {
                t.insert(s.substring(i, j));
            }
        }
        return t.wordCount + 1; // "" was not accounted
    }
}