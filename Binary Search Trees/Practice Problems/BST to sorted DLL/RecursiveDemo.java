class Solution {
    
    public TreeNode bstToSortedDLL(TreeNode root) {
        TreeNode[] inorderSucc = new TreeNode[1];
        solve(root, inorderSucc);
        return inorderSucc[0];
    }

    public void solve(TreeNode root, TreeNode[] inorderSucc) {
        if(root == null) return;

        solve(root.right, inorderSucc);

        root.right = inorderSucc[0];
        if(inorderSucc != null) inorderSucc[0].left = root;
        inorderSucc[0] = root;

        solve(root.left, inorderSucc);
    }
}