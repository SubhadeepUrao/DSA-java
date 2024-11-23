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
    public List<Integer> postorderTraversal(TreeNode root) {
        // using two stack
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack1st = new Stack<>();
        Stack<TreeNode> stack2nd = new Stack<>();

        if(root == null) return list;

        stack1st.push(root);
        while(!stack1st.empty()) {
            root = stack1st.pop();
            stack2nd.push(root);
            if(root.left != null) stack1st.push(root.left);
            if(root.right != null) stack1st.push(root.right);
        }
        while(!stack2nd.empty()) {
            list.add(stack2nd.pop().val);
        }
        return list;
    }
}