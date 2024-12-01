class Solution {
    public Node inorderSuccessor(Node root, Node x) {
        if (root == null)
            return null;

        Node inorderSucc = null;
        Node res;
        if (x.data < root.data) {
            inorderSucc = root;
            res = inorderSuccessor(root.left, x);
        } else
            res = inorderSuccessor(root.right, x);

        return res == null ? inorderSucc : res;
    }
}