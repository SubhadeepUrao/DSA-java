import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    static class Pair implements Comparable<Pair> {
        TreeNode node;
        int row;
        int col;

        Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }

        public int compareTo(Pair that) {
            if (this.col != that.col) {
                return this.col - that.col;
            } else if (this.row != that.row) {
                return this.row - that.row;
            }
            return this.node.val - that.node.val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        PriorityQueue<Pair> q = new PriorityQueue<>();
        dfs(root, 0, 0, q);
        List<List<Integer>> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            List<Integer> k = new ArrayList<>();
            int g = q.peek().col;
            while (!q.isEmpty() && q.peek().col == g) {
                Pair curr = q.poll();
                k.add(curr.node.val);
            }
            ans.add(k);
        }
        return ans;
    }

    static void dfs(TreeNode node, int row, int col, PriorityQueue<Pair> q) {
        if (node == null)
            return;
        Pair newPair = new Pair(node, row, col);
        q.add(newPair);
        dfs(node.left, row + 1, col - 1, q);
        dfs(node.right, row + 1, col + 1, q);

    }
}