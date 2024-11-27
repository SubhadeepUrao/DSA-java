class TreeNode {
    int data;
    TreeNode left, right;
    TreeNode(int data) {
        this.data = data;
    }
}

class Solution {
    public void maintainChildrenSum(TreeNode root) {
        if(root == null || root.left == root.right) return;

        int left = 0, right = 0;

        if(root.left != null) left = root.left.data;
        if(root.right != null) right = root.right.data;

        if(root.data > left + right) {
            if(root.left != null) root.left.data = root.data;
            else if(root.right != null) root.right.data = root.data;
        }

        maintainChildrenSum(root.left);
        maintainChildrenSum(root.right);
        
        left = right = 0;

        if(root.left != null) left = root.left.data;
        if(root.right != null) right = root.right.data;

        root.data = left + right;
    }
}