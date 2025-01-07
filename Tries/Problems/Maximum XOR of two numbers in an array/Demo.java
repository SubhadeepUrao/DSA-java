class Node {
    Node[] next = new Node[2];
}

class Trie {
    Node root;
    int mask;

    Trie() {
        root = new Node();
        mask = 1 << 30;
    }

    void insert(int num) {
        int N = num;
        Node curr = root;
        for (int i = 0; i < 31; ++i) {
            int ind = (N & mask) > 0 ? 1 : 0;
            if (curr.next[ind] == null)
                curr.next[ind] = new Node();
            curr = curr.next[ind];
            N <<= 1;
        }
    }

    int maximumXOR(int num) {
        int N = num;
        int XOR = 0;
        Node curr = root;
        for (int i = 0; i < 31; ++i) {
            int ind = (N & mask) > 0 ? 1 : 0;
            if (curr.next[1 - ind] != null) { // opposite branch exists
                XOR = (XOR << 1) | 1;
                ind = 1 - ind;
            } else
                XOR = XOR << 1; // we go for same branch

            curr = curr.next[ind];
            N <<= 1;
        }
        return XOR;
    }

}

class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie t = new Trie();

        int maxi = 0;
        for (int num : nums) {
            t.insert(num);
            maxi = Math.max(maxi, t.maximumXOR(num));
        }
        return maxi;
    }
    // public int findMaximumXOR(int[] nums) {
    //     Trie t = new Trie();
    //     for (int num : nums)
    //         t.insert(num);

    //     int maxi = 0;
    //     for (int num : nums) {
    //         maxi = Math.max(maxi, t.maximumXOR(num));
    //     }
    //     return maxi;
    // }
}