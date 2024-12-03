import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}

class Solution {
   static TreeNode bstToSortedDLL(TreeNode root) {
       TreeNode inorderSucc = null;

       while(root != null) {
           if(root.right == null) {
               root.right = inorderSucc;
               inorderSucc = root;
               root = root.left;
           }
           else {
               TreeNode prev = root.right;

               while(prev.left != null && prev.left != root) {
                   prev = prev.left;
               }

               if(prev.left == null) {
                   prev.left = root;
                   root = root.right;
               }
               else {
                   root.right = inorderSucc;
                   inorderSucc = root;
                   root = root.left;
               }
           }
       }
       return inorderSucc;
   }

   static List<Integer> mergeLL(TreeNode root1, TreeNode root2) {
       List<Integer> res = new ArrayList<>();

       while(root1 != null && root2 != null) {
           if(root1.data <= root2.data) {
               res.add(root1.data);
               root1 = root1.right;
           }
           else {
               res.add(root2.data);
               root2 = root2.right;
           }
       }
       while(root1 != null) {
           res.add(root1.data);
           root1 = root1.right;
       }
       while(root2 != null) {
           res.add(root2.data);
           root2 = root2.right;
       }

       return res;
   }
   public static List<Integer> mergeBST(TreeNode root1, TreeNode root2) {
       root1 = bstToSortedDLL(root1);
       root2 = bstToSortedDLL(root2);

       return mergeLL(root1, root2);
   }
}