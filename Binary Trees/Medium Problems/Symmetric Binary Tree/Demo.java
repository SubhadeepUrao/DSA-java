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
    boolean dfs(TreeNode leftSubtreeRoot, TreeNode rightSubtreeRoot) {
        if(leftSubtreeRoot == null && rightSubtreeRoot == null) return true;
        if(leftSubtreeRoot == null || rightSubtreeRoot == null) return false;
        
        if(leftSubtreeRoot.val != rightSubtreeRoot.val) return false;

        return dfs(leftSubtreeRoot.right, rightSubtreeRoot.left) &&
                dfs(leftSubtreeRoot.left, rightSubtreeRoot.right);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root.left == root.right) return true;
        
        return dfs(root.left, root.right); 
    }
}