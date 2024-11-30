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
    TreeNode findAndDeleteLeftMost(TreeNode root, TreeNode nodeToDelete) { 
        // delete inorder-successor
        if(root.left == null) {
            nodeToDelete.val = root.val;
            return root.right;
        }
        root.left = findAndDeleteLeftMost(root.left, nodeToDelete);
        return root;
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(root.val == key) {
            if(root.left != null && root.right != null) {
                root.right = findAndDeleteLeftMost(root.right, root);
                return root;
            }
            else if(root.left == null)
                return root.right;
            else
                return root.left;
        }

        if(key < root.val)
            root.left = deleteNode(root.left, key);
        else
            root.right = deleteNode(root.right, key);
        
        return root;
    }
}