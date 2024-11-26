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
    static void dfs(TreeNode root, ArrayList<String> res, StringBuilder str) {
        if(root == null) return;

        int n = str.length();
        str.append(root.val);

        if(root.left == root.right) {
            res.add(str.toString());
        }
        else {
            str.append("->");
            dfs(root.left, res, str);
            dfs(root.right, res, str);
        }

        str.setLength(n);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        if(root == null) return res;
        
        StringBuilder str = new StringBuilder();
        dfs(root, res, str);
        
        return res;
    }
}