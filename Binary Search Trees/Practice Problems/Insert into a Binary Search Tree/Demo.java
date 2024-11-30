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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);

        TreeNode curr = root;
        while(curr != null) {
            if(val < curr.val) {
                if(curr.left == null) {
                    curr.left = new TreeNode(val);
                    return root;
                }
                curr = curr.left;
            }
            else {
                if(curr.right == null) {
                    curr.right = new TreeNode(val);
                    return root;
                }
                curr = curr.right;
            }
        }
        return root;
    }
    
    // public TreeNode insertIntoBST(TreeNode root, int val) {
    //     if(root == null) return new TreeNode(val);

    //     if(val < root.val) root.left = insertIntoBST(root.left, val);
    //     else root.right = insertIntoBST(root.right, val);

    //     return root;
    // }
}