class TreeNode {
    int data;
    TreeNode left, right;
    TreeNode(int data) {
        this.data = data;
    }
}

class Solution {
    public TreeNode bstToSortedDLL(TreeNode root) {
        TreeNode inorderSucc = null;
        while(root != null) {
            if(root.right == null) {
                root.right = inorderSucc;
                if(inorderSucc != null) inorderSucc.left = root;
                inorderSucc = root;
                root = root.left;
            }
            else {
                TreeNode prev = root.right;

                while(prev.left != null && prev.left != root)
                    prev = prev.left;

                if(prev.left == null) {
                    prev.left = root;
                    root = root.right;
                }
                else {
                    root.right = inorderSucc;
                    if(inorderSucc != null) inorderSucc.left = root;
                    inorderSucc = root;
                    root = root.left;
                }
            }
        }
        return inorderSucc;
    }
}