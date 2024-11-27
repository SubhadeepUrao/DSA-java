class Node {
    public int data;
    public Node left;
    public Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Solution {
   public static boolean isParentSum(Node root) {
       if(root == null || root.left == root.right) return true;
       
       int left = 0, right = 0;
       
       if(root.left != null) left = root.left.data;
       if(root.right != null) right = root.right.data;
       
       if(root.data == left + right) {
           return isParentSum(root.left) && isParentSum(root.right) ? true : false;
       }
       return false;
   }
}