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
    static int findMaxDiameter(TreeNode root, int[] max) {
        if(root == null) return 0;
        int leftHeight = findMaxDiameter(root.left, max);
        int rightHeight = findMaxDiameter(root.right, max);
        max[0] = Math.max(max[0], leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        
        int[] max = new int[1];
        findMaxDiameter(root, max);
        return max[0];
    }
}