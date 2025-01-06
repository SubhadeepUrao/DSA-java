class Node {
    Node[] next = new Node[26];
    boolean word;
}

class Trie {
    Node root;

    Trie() {
        root = new Node();
    }

    void insert(String word) {
        int i = 0;
        int N = word.length();
        Node curr = root;
        while (i < N) {
            int ind = word.charAt(i++) - 'a';
            if (curr.next[ind] == null) curr.next[ind] = new Node();
            curr = curr.next[ind];
        }
        curr.word = true;
    }

    boolean search(String word) {
        int i = 0;
        int N = word.length();
        Node curr = root;
        while (i < N) {
            int ind = word.charAt(i++) - 'a';
            if (curr.next[ind] == null) return false;
            curr = curr.next[ind];
        }
        return curr.word;
    }
}

class Solution {
    public static String completeString(int n, String[] a) {
        Trie t = new Trie();
        for (String word : a) t.insert(word);

        int maxi = 0;
        String res = "";
        for (String word : a) {
            int size = word.length();
            int i;
            for (i = 1; i < size; ++i) {
                if (!t.search(word.substring(0, i)))
                    break;
            }
            if (i == size) {
                if (maxi < size) {
                    maxi = size;
                    res = word;
                } else if (maxi == size) {
                    res = res.compareTo(word) < 0 ? res : word;
                }
            }
        }
        return res.equals("") ? "None" : res;
    }
}