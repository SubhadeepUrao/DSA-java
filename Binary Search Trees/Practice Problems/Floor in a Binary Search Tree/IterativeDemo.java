class Solution {
    public static int floor(Node root, int key) {
        int floor = -1;
        
        while(root != null) {
            if(root.data == key) return key;
            
            if(key < root.data)
                root = root.left;
            else {
                floor = root.data;
                root = root.right;
            }
        }
        return floor;
    }
}