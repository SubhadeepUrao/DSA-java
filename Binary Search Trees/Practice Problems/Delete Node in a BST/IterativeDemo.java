class Solution {
    TreeNode findAndDeleteLeftMost(TreeNode root, TreeNode nodeToDelete) { 
        // delete inorder-successor
        TreeNode parent = null;
        TreeNode curr = root;

        while(curr.left != null) {
            parent = curr;
            curr = curr.left;
        }

        nodeToDelete.val = curr.val;

        if(parent == null)
            return curr.right;
        else
            parent.left = curr.right;
        
        return root;
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode parent = null;
        TreeNode curr = root;

        while(curr != null && curr.val != key) {
            parent = curr;
            
            if(key < curr.val)
                curr = curr.left;
            else
                curr = curr.right;
        }

        if(curr == null) return root;

        if(curr.left != null && curr.right != null) {
            curr.right = findAndDeleteLeftMost(curr.right, curr);
        }
        else {
            TreeNode child = curr.left == null ? curr.right : curr.left;

            if(parent == null) return child;

            if(parent.left == curr)
                parent.left = child;
            else
                parent.right = child;
        }

        return root;
    }
}