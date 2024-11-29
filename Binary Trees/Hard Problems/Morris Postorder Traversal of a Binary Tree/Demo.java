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

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        while(root != null) {
            if(root.right == null) {
                res.add(0, root.val);
                root = root.left;
            }
            else {
                TreeNode prev = root.right;

                while(prev.left != null && prev.left != root) {
                    prev = prev.left;
                }

                if(prev.left == null) {
                    prev.left = root;
                    res.add(0, root.val);
                    root = root.right;
                }
                else {
                    prev.left = null;
                    root = root.left;
                }
            }
        }
        return res;
    }
}