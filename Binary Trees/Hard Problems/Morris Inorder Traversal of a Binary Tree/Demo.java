import java.util.ArrayList;
import java.util.List;

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

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        while(root != null) {
            if(root.left == null) {
                res.add(root.val);
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
                    prev.right = null;
                    res.add(root.val);
                    root = root.right;
                }
            }
        }
        return res;
    }
}