class Trie {
    class Node {
        Node[] next = new Node[26];
        boolean word;
    }

    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        int i = 0;
        int N = word.length();
        Node curr = root;
        while (i < N && curr.next[word.charAt(i) - 97] != null) {
            curr = curr.next[word.charAt(i++) - 97];
        }
        while (i != N) {
            curr = curr.next[word.charAt(i++) - 97] = new Node();
        }
        curr.word = true;
    }

    public boolean search(String word) {
        int i = 0;
        int N = word.length();
        Node curr = root;
        while (i < N && curr.next[word.charAt(i) - 97] != null) {
            curr = curr.next[word.charAt(i++) - 97];
        }
        return i == N && curr.word;
    }

    public boolean startsWith(String prefix) {
        int i = 0;
        int N = prefix.length();
        Node curr = root;
        while (i < N && curr.next[prefix.charAt(i) - 97] != null) {
            curr = curr.next[prefix.charAt(i++) - 97];
        }
        return i == N;
    }
}
