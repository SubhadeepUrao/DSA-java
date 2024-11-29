// time complexity : O(N)
// space complexity : O(1)
// concept of threaded binary tree used

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

    public void flatten(TreeNode root) {

        while(root != null) {
            if(root.left == null) {
                root = root.right;
            }
            else {
                TreeNode prev = root.left;

                while(prev.right != null && prev.right != root)
                    prev = prev.right;
                
                if(prev.right == null) {
                    prev.right = root;
                    root = root.left;
                }
                else {
                    prev.right = root.right;
                    root.right = root.left;
                    root.left = null;
                    root = prev.right;
                }
            }
        }
    }
}