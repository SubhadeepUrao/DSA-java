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
    void inorder(TreeNode root, int k, int[] cnt, int[] kthLargest) {
        if(root == null) return;
        
        inorder(root.right, k, cnt, kthLargest);
        cnt[0]++;
        if (cnt[0] == k) {
            kthLargest[0] = root.val;
            return;
        }
        inorder(root.left, k, cnt, kthLargest);
    }

    public int kthLargest(TreeNode root, int k) {
        // works for any node values
        int[] cnt = new int[1];
        int[] kthLargest = new int[1];
        inorder(root, k, cnt, kthLargest);
        return kthLargest[0];
    }

    // public int kthLargest(TreeNode root, int k) {
    //     if(root == null) return -1;

    //     int right = kthLargest(root.right, k);
    //     if(right >= 0) return right;

    //     if(k + right == 0) return root.val;

    //     int left = kthLargest(root.left, k + right);
    //     if(left >= 0) return left;

    //     return left + right;
    // }
}