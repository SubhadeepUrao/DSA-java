class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
    }
}

class Solution {
    // Function to return the ceil of given number in BST.
    int findCeil(Node root, int key) {
        if (root == null) return -1;
        
        if(root.data == key) return key;
        
        if(key < root.data) {
            int ceil = findCeil(root.left, key);
            
            return ceil == -1 ? root.data : ceil;
        }
        
        return findCeil(root.right, key);
    }
}