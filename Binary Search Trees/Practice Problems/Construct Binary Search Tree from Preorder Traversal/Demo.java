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
    int p;
    TreeNode buildBST(int[] preorder, int stop) {
        if(p == preorder.length || preorder[p] > stop)
            return null;

        TreeNode root = new TreeNode(preorder[p++]);

        root.left = buildBST(preorder, root.val);
        root.right = buildBST(preorder, stop);
        
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildBST(preorder, Integer.MAX_VALUE);
    }
}