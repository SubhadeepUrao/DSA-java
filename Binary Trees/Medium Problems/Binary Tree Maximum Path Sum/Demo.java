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
   static int solve(TreeNode root, int[] maxi) {
       if(root == null) return 0;

       int leftSum = Math.max(0, solve(root.left, maxi));
       int rightSum = Math.max(0, solve(root.right, maxi));

       maxi[0] = Math.max(maxi[0], leftSum + rightSum + root.val);

       return root.val + Math.max(leftSum, rightSum);
   }
   public int maxPathSum(TreeNode root) {
       int[] maxi = new int[]{Integer.MIN_VALUE};
       solve(root, maxi);

       return maxi[0];
   }
}