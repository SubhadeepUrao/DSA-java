import java.util.Arrays;

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
        int XOR = 0;
        int N = num;
        Node curr = root;
        for (int i = 0; i < 31; ++i) {
            int ind = (N & mask) > 0 ? 1 : 0;
            if (curr.next[1 - ind] != null) {
                XOR = (XOR << 1) | 1;
                ind = 1 - ind;
            } else
                XOR <<= 1;
            curr = curr.next[ind];
            N <<= 1;
        }
        return XOR;
    }
}

class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Trie t = new Trie();

        int[][] offlineQuery = new int[queries.length][3];
        for (int i = 0; i < queries.length; ++i) {
            offlineQuery[i][0] = queries[i][0];
            offlineQuery[i][1] = queries[i][1];
            offlineQuery[i][2] = i;
        }
        Arrays.sort(offlineQuery, (a, b) -> Integer.compare(a[1], b[1]));
        Arrays.sort(nums);

        int[] res = new int[queries.length];
        int i = 0;
        int N = nums.length;

        for (int[] query : offlineQuery) {
            int limit = query[1];

            while (i < N && nums[i] <= limit) {
                t.insert(nums[i++]);
            }

            res[query[2]] = i == 0 ? -1 : t.maximumXOR(query[0]);
        }
        return res;
    }
}