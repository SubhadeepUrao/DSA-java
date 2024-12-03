class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
}

class Solution {
    TreeNode[] bstToDLL(TreeNode root) {
        TreeNode inorderSucc = null;
        TreeNode tail = null;

        while(root != null) {
            if(root.right == null) {
                if(inorderSucc == null) tail = root;
                root.right = inorderSucc;
                if(inorderSucc != null) inorderSucc.left = root;
                inorderSucc = root;
                root = root.left;
            }
            else {
                TreeNode prev = root.right;

                while(prev.left != null && prev.left != root) {
                    prev = prev.left;
                }

                if(prev.left == null) {
                    prev.left = root;
                    root = root.right;
                }
                else {
                    if(inorderSucc == null) tail = root;
                    root.right = inorderSucc;
                    if(inorderSucc != null) inorderSucc.left = root;
                    inorderSucc = root;
                    root = root.left;
                }
            }
        }
        return new TreeNode[]{ inorderSucc, tail }; 
    }
    public boolean findTarget(TreeNode root, int k) {
        TreeNode[] extremes = bstToDLL(root);
        TreeNode left = extremes[0];
        TreeNode right = extremes[1];

        while(left.val < right.val) {
            int sum = left.val + right.val;
            if(sum == k) return true;
            if(sum < k)
                left = left.right;
            else
                right = right.left;
        }
        return false;
    }
}