class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    // Function to find the minimum element in the given BST.
    int minValue(Node root) {
        if(root == null) return -1;
        
        while(root.left != null) {
            root = root.left;
        }
        
        return root.data;
    }
    // Function to find the maximum element in the given BST.
    int maxValue(Node root) {
        if(root == null) return -1;
        
        while(root.right != null) {
            root = root.right;
        }
        
        return root.data;
    }
}