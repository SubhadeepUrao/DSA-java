import java.util.Stack;

class BSTIterator {
    Stack<TreeNode> st;
    TreeNode root;
    boolean reverse;
    public BSTIterator(TreeNode root, boolean reverse) {
        st = new Stack<>();
        this.root = root;
        this.reverse = reverse;
    }
    
    public int next() {
        // if(!hasNext()) return -1;

        while(root != null) {
            st.push(root);
            if(reverse) root = root.right;
            else root = root.left;
        }
        if(reverse) root = st.peek().left;
        else root = st.peek().right;
        return st.pop().val;
    }
    
    public boolean hasNext() {
        return root != null || !st.empty();
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator front = new BSTIterator(root, false);
        BSTIterator rear = new BSTIterator(root, true);
    
        int left = front.next();
        int right = rear.next();
    
        while(left < right) {
            int sum = left + right;
            if(sum == k) return true;
            if(sum < k)
                left = front.next();
            else
                right = rear.next();
        }
        return false;
    }
}