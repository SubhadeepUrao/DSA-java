class Solution {
    int i, p;
    TreeNode solve(int[] inorder, int[] postorder, int stop) {
        if(p < 0) return null;
        
        if(inorder[i] == stop) {
            --i;
            return null;
        }

        TreeNode root = new TreeNode(postorder[p--]);
        root.right = solve(inorder, postorder, root.val);
        root.left = solve(inorder, postorder, stop);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        i = p = inorder.length-1;
        return solve(inorder, postorder, Integer.MAX_VALUE);
    }
}