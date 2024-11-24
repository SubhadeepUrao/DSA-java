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

    // static int height(TreeNode root) {
    //     if(root == null) return -1;
    //     return Math.max(height(root.left), height(root.right)) + 1;
    // }
    // public boolean isBalanced(TreeNode root) {
    //     if(root == null) return true;
    //     int diff = height(root.left) - height(root.right);
    //     if(diff > 1 || diff < -1) return false;
        
    //     return isBalanced(root.left) && isBalanced(root.right);
    // }

    static int heightModified(TreeNode root) {
        if(root == null) return 0; // we do not really care about calculating height

        int leftHeight = heightModified(root.left);
        if(leftHeight == -1) return -1;

        int rightHeight = heightModified(root.right);
        if(rightHeight == -1) return -1;

        int diff = leftHeight - rightHeight;
        if(diff > 1 || diff < -1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return heightModified(root) == -1 ? false : true;
    }
}