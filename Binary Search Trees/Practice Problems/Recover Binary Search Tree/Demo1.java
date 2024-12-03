class Solution {
    TreeNode first;
    TreeNode last;
    TreeNode prev;

    public void solve(TreeNode root) {
        if(root == null) return;

        solve(root.left);
        if(prev.val > root.val) {
            if(first == null) first = prev;
            last = root;
        }
        prev = root;
        solve(root.right);
    }
    public void recoverTree(TreeNode root) {
        prev = new TreeNode(Integer.MIN_VALUE);
        solve(root);

        swap(first, last);
    }
    void swap(TreeNode first, TreeNode scnd) {
        int temp = first.val;
        first.val = scnd.val;
        scnd.val = temp;
    }
}