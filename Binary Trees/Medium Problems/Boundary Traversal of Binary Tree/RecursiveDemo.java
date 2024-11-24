import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Solution {
   static void leftBoundary(List<Integer> list, TreeNode root) {
       if(root.left == root.right) return;
       
       list.add(root.data);

       if(root.left != null) leftBoundary(list, root.left);
       else leftBoundary(list, root.right);
   }
   static void addLeaves(List<Integer> list, TreeNode root) {
       if(root.left == root.right) list.add(root.data);
       
       if(root.left != null) addLeaves(list, root.left);
       if(root.right != null) addLeaves(list, root.right);
   }

   static void rightBoundary(List<Integer> list, TreeNode root) {
       if(root.left == root.right) return;

       if(root.right != null) rightBoundary(list, root.right);
       else rightBoundary(list, root.left);

       list.add(root.data);
   }
   public static List<Integer> traverseBoundary(TreeNode root){
       List<Integer> list = new ArrayList<>();

       if(root == null) return list;

       if(root.left != root.right) list.add(root.data);
       if(root.left != null) leftBoundary(list, root.left);
       addLeaves(list, root);
       if(root.right != null) rightBoundary(list, root.right);

       return list;
   }
}