import java.util.Stack;

class Solution {

    // public int kthSmallest(TreeNode root, int k) {
    //     // Morris inorder traversal
    //     int cnt = 0;
    //     int kthSmallest = -1;

    //     while(root != null) {
    //         if(root.left == null) {
    //             cnt++;
    //             if(cnt == k) kthSmallest = root.val;
    //             root = root.right;
    //         }
    //         else {
    //             TreeNode prev = root.left;

    //             while(prev.right != null && prev.right != root) {
    //                 prev = prev.right;
    //             }

    //             if(prev.right == null) {
    //                 prev.right = root;
    //                 root = root.left;
    //             }
    //             else {
    //                 cnt++;
    //                 if(cnt == k) kthSmallest = root.val;
    //                 prev.right = null;
    //                 root = root.right;
    //             }
    //         }
    //     }
    //     return kthSmallest;
    // }

    public int kthSmallest(TreeNode root, int k) {
        int cnt = 0;
        Stack<TreeNode> st = new Stack<>();

        while(root != null || !st.empty()) {
            while(root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            cnt++;
            if(cnt == k) return root.val;
            root = root.right;
        }
        return -1;
    }
}