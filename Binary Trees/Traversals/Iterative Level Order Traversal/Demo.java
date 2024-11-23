import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Breadth-First Traversal
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null) return list;

        q.offer(root);
        while(!q.isEmpty()) {
            int n = q.size();
            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < n; ++i) {
                root = q.poll();
                level.add(root.val);
                if(root.left != null) q.offer(root.left);
                if(root.right != null) q.offer(root.right);
            }
            list.add(level);
        }
        return list;
    }
}