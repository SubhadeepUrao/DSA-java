class BSTIterator {
    TreeNode head;
    TreeNode tempHead;
    public BSTIterator(TreeNode root) {
        head = new TreeNode(-1);
        tempHead = head;
        createLL(root);
    }

    void createLL(TreeNode root) {
        if(root == null) return;

        createLL(root.left);
        tempHead.right = new TreeNode(root.val);
        tempHead = tempHead.right;
        createLL(root.right);
    }
    
    public int next() {
        head = head.right;
        return head.val;
    }
    
    public boolean hasNext() {
        return head.right != null;
    }
}