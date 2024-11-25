import java.util.ArrayList;
import java.util.List;

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
    void dfs(TreeNode root, int row, List<Integer> res) {
        if(root == null) return;

        if(row == res.size())
            res.add(root.val);
        else
            res.set(row, root.val);

        dfs(root.right, row + 1, res);
        dfs(root.left, row + 1, res);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        dfs(root, 0, res);

        return res;
    }
}