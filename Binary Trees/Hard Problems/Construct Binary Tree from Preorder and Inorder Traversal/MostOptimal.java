class Solution {
    int p, i;
    TreeNode solve(int[] preorder, int[] inorder, int stop) {
        
        if(p == preorder.length) return null;

        if(inorder[i] == stop) {
            ++i;
            return null;
        }
        TreeNode root = new TreeNode(preorder[p++]);
        root.left = solve(preorder, inorder, root.val);
        root.right = solve(preorder, inorder, stop);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return solve(preorder, inorder, Integer.MAX_VALUE);
    }
}