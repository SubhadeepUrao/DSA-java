class Solution {
    boolean solve(TreeNode root, long mini, long maxi) {
        if(root == null) return true;

        if(root.val <= mini || maxi <= root.val)
            return false;
        
        return solve(root.left, mini, root.val) && solve(root.right, root.val, maxi);
    }
    public boolean isValidBST(TreeNode root) {
        return solve(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}