import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    class Pair {
        TreeNode node;
        int pos;
        Pair(TreeNode node, int pos) {
            this.node = node;
            this.pos = pos;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int res = 0;
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0));
        while(!q.isEmpty()) {
            int min = q.peek().pos;
            int n = q.size();
            int first = 0;
            int last = 0;
            for(int i = 0; i < n; ++i) {
                int currPos = q.peek().pos - min;
                root = q.poll().node;
                if(i == 0) first = currPos;
                if(i == n-1) last = currPos;

                if(root.left != null) q.offer(new Pair(root.left, currPos * 2 + 1));
                if(root.right != null) q.offer(new Pair(root.right, currPos * 2 + 2));
            }
            res = Math.max(res, last - first + 1);
        }
        return res;
    }
}