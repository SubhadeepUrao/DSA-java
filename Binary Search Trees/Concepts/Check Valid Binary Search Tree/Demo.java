// Given an array of integers arr[] representing inorder traversal of elements
// of a binary tree. Return true if the given inorder traversal can be of a
// valid Binary Search Tree.

// Note - In a valid Binary Search Tree all keys are unique.

// BST follows leftChild < root < rightChild scheme

// Inorder traversal of BST will always result in elements arranged in sorted order

class Solution {
    static boolean isBSTTraversal(int arr[]) {
        int n = arr.length;
        for(int i = 1; i < n; ++i) {
            if(arr[i-1] >= arr[i])
                return false;
        }
        return true;
    }
}