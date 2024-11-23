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
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     List<Integer> list = new ArrayList<>();
    //     Stack<TreeNode> st = new Stack<>();

    //     if(root == null) return list;

    //     st.push(root);
    //     while(!st.empty()) {
    //         root = st.pop();
    //         list.add(0, root.val);
    //         if(root.left != null) st.push(root.left);
    //         if(root.right != null) st.push(root.right);
    //     }
    //     return list;
    // }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        // using one stack
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        while (root != null || !st.empty()) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            if(st.peek().right != null) {
                root = st.peek().right;
            }
            else {
                do {
                    root = st.pop();
                    list.add(root.val);
                } while(!st.empty() && st.peek().right == root);
                
                root = null;
            }
        }
        return list;
    }
}