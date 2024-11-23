import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
        Stack<TreeNode> st = new Stack<>();
        List<Integer> list = new ArrayList<>();

        while(root != null || !st.empty()) {
            while(root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            list.add(root.val);
            root = root.right;
        }

        return list;
    }
    
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     // original tree gets destroyed
    //     Stack<TreeNode> st = new Stack<>();
    //     List<Integer> list = new ArrayList<>();
        
    //     if(root == null) return list;

    //     st.push(root);
    //     while(!st.empty()) {
    //         root = st.pop();
    //         if(root.left == null && root.right == null) {
    //             list.add(root.val);
    //             continue;
    //         }
    //         TreeNode left = root.left;
    //         TreeNode right = root.right;
    //         root.left = root.right = null;
    //         if(right != null) st.push(right);
    //         st.push(root);
    //         if(left != null) st.push(left);
    //     }
    //     return list;
    // }
}