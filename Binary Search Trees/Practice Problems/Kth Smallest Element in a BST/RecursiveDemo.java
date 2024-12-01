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
    void inorder(TreeNode root, int k, int[] cnt, int[] kthSmallest) {
        if(root == null) return;
        
        inorder(root.left, k, cnt, kthSmallest);
        cnt[0]++;
        if (cnt[0] == k) {
            kthSmallest[0] = root.val;
            return;
        }
        inorder(root.right, k, cnt, kthSmallest);
    }

    public int kthSmallest(TreeNode root, int k) {
        // works for any node values
        int[] cnt = new int[1];
        int[] kthSmallest = new int[1];
        inorder(root, k, cnt, kthSmallest);
        return kthSmallest[0];
    }

    // public int kthSmallest(TreeNode root, int k) {
    //     // 1 <= k <= n <= 10^4
    //     // 0 <= Node.val <= 10^4 i.e. non-negative node values
        
    //     if(root == null) return -1;

    //     int left = kthSmallest(root.left, k);
    //     if(left >= 0) return left;

    //     if(k + left == 0) return root.val;

    //     int right = kthSmallest(root.right, k + left);
    //     if(right >= 0) return right;

    //     return left + right;
    // }
}