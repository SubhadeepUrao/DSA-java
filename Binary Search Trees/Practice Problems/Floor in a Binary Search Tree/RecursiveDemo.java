class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
    }
}

class Solution {
    public static int floor(Node root, int key) {
        if(root == null) return -1;
        
        if(root.data == key) return key;
        
        if(key < root.data)
            return floor(root.left, key);
        
        int floor = floor(root.right, key);
        return floor == -1 ? root.data : floor;
    }
}