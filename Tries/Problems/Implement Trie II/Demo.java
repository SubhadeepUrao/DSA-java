class Node {
    Node[] next = new Node[26];
    boolean word;
    int wordCount; // Count of words ending at this node
    int follow;    // Count of words passing through this node
}

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        int i = 0;
        int N = word.length();
        Node curr = root;

        while (i < N) {
            ++curr.follow;
            int ind = word.charAt(i++) - 'a';
            if (curr.next[ind] == null) {
                curr.next[ind] = new Node();
            }
            curr = curr.next[ind];
        }
        ++curr.follow;
        ++curr.wordCount;
        curr.word = true;
    }

    public int countWordsEqualTo(String word) {
        int i = 0;
        int N = word.length();
        Node curr = root;

        while (i < N) {
            int ind = word.charAt(i++) - 'a';
            if (curr.next[ind] == null) return 0; // Word not found
            curr = curr.next[ind];
        }
        return curr.wordCount;
    }

    public int countWordsStartingWith(String prefix) {
        int i = 0;
        int N = prefix.length();
        Node curr = root;

        while (i < N) {
            int ind = prefix.charAt(i++) - 'a';
            if (curr.next[ind] == null) return 0; // Prefix not found
            curr = curr.next[ind];
        }
        return curr.follow;
    }

    public void erase(String word) {
        if (countWordsEqualTo(word) == 0) return; // Word not found

        eraseHelper(root, word, 0);
    }

    private boolean eraseHelper(Node node, String word, int depth) {
        if (node == null) return false;

        if (depth == word.length()) {
            --node.follow;
            --node.wordCount;
            if (node.wordCount == 0) node.word = false;
            return node.follow == 0; // Return true if node can be deleted
        }

        int ind = word.charAt(depth) - 'a';
        boolean canDeleteChild = eraseHelper(node.next[ind], word, depth + 1);

        if (canDeleteChild) {
            node.next[ind] = null; // Delete child node
        }

        --node.follow;
        return node.follow == 0 && !node.word;
    }
}
