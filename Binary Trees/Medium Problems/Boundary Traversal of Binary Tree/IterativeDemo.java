import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Solution {
    static void leftBoundary(List<Integer> list, TreeNode root) {
        while(root.left != root.right) {
            list.add(root.data);
            if(root.left != null) root = root.left;
            else root = root.right;
        }
    }

    static void addLeaves(List<Integer> list, TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        st.add(root);
        while(!st.empty()) {
            root = st.pop();
            
            if(root.left == root.right) list.add(root.data);

            if(root.right != null) st.push(root.right);
            if(root.left != null) st.push(root.left);
        }
    }

    static void rightBoundary(List<Integer> list, TreeNode root) {
        List<Integer> revlist = new ArrayList<>();
        while(root.left != root.right) {
            revlist.add(0, root.data);
            if(root.right != null) root = root.right;
            else root = root.left;
        }
        list.addAll(revlist);
    }
    public static List<Integer> traverseBoundary(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if(root == null) return list;

        if(root.left != root.right) list.add(root.data);
        if(root.left != null) leftBoundary(list, root.left);
        addLeaves(list, root);
        if(root.right != null) rightBoundary(list, root.right);

        return list;
    }
}