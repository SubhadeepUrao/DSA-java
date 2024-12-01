class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class Solution {
    public Node inorderSuccessor(Node root, Node x) {
        Node inorderSucc = null;

        while (root != null) {
            if (x.data < root.data) {
                inorderSucc = root;
                root = root.left;
            } else
                root = root.right;
        }

        return inorderSucc;
    }

    // Node inorderSuccessor(Node root) {
    //     while (root.left != null) {
    //         root = root.left;
    //     }
    //     return root;
    // }
    // // returns the inorder successor of the Node x in BST (rooted at 'root')
    // public Node inorderSuccessor(Node root, Node x) {
    //     Node inorderSucc = null;

    //     while (root.data != x.data) {
    //         if (x.data < root.data) {
    //             inorderSucc = root;
    //             root = root.left;
    //         } else
    //             root = root.right;
    //     }

    //     return root.right == null ? inorderSucc : inorderSuccessor(root.right);
    // }
}