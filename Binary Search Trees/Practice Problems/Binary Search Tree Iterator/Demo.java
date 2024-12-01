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

class BSTIterator {
    Stack<TreeNode> st;
    TreeNode root;
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        this.root = root;
    }
    
    public int next() {
        // if(!hasNext()) return -1;

        while(root != null) {
            st.push(root);
            root = root.left;
        }
        root = st.peek().right;
        return st.pop().val;
    }
    
    public boolean hasNext() {
        return root != null || !st.empty();
    }
}