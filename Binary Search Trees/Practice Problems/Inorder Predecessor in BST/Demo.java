class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class Solution {
    public Node inorderPredecessor(Node root, Node x) {
        Node inorderPred = null;

        while (root != null) {
            if (x.data < root.data)
                root = root.left;
            else {
                inorderPred = root;
                root = root.right;
            }
        }

        return inorderPred;
    }
}