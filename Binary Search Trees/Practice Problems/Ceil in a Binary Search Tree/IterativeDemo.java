class Solution {
    // Function to return the ceil of given number in BST.
    int findCeil(Node root, int key) {
        int ceil = -1;

        while(root != null) {
            if(root.data == key) return key;

            if(key < root.data) {
                ceil = root.data;
                root = root.left;
            }
            else
                root = root.right;
        }
        return ceil;
    }
}