import java.util.Stack;

class Solution {

    // public int kthLargest(TreeNode root, int k) {
    //     // Morris inorder traversal
    //     int cnt = 0;
    //     int kthLargest = -1;

    //     while(root != null) {
    //         if(root.right == null) {
    //             cnt++;
    //             if(cnt == k) kthLargest = root.val;
    //             root = root.left;
    //         }
    //         else {
    //             TreeNode prev = root.right;

    //             while(prev.left != null && prev.left != root) {
    //                 prev = prev.left;
    //             }

    //             if(prev.left == null) {
    //                 prev.left = root;
    //                 root = root.right;
    //             }
    //             else {
    //                 cnt++;
    //                 if(cnt == k) kthLargest = root.val;
    //                 prev.left = null;
    //                 root = root.left;
    //             }
    //         }
    //     }
    //     return kthLargest;
    // }

    public int kthLargest(TreeNode root, int k) {
        int cnt = 0;
        Stack<TreeNode> st = new Stack<>();

        while(root != null || !st.empty()) {
            while(root != null) {
                st.push(root);
                root = root.right;
            }
            root = st.pop();
            cnt++;
            if(cnt == k) return root.val;
            root = root.left;
        }
        return -1;
    }
}