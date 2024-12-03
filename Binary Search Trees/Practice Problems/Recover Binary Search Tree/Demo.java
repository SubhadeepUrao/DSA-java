class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
}

class Solution {
    TreeNode first;
    TreeNode middle;
    TreeNode last;
    TreeNode prev;

    public void solve(TreeNode root) {
        if(root == null) return;

        solve(root.left);
        if(prev.val > root.val) {
            if(first == null) {
                first = prev;
                middle = root;
            }
            else
                last = root;
        }
        prev = root;
        solve(root.right);
    }
    public void recoverTree(TreeNode root) {
        prev = new TreeNode(Integer.MIN_VALUE);
        solve(root);

        if(last == null) swap(first, middle);
        else swap(first, last);
    }
    void swap(TreeNode first, TreeNode scnd) {
        int temp = first.val;
        first.val = scnd.val;
        scnd.val = temp;
    }
}