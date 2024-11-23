import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
    }
}
public class Demo {
    static int leftChild(int i) { return (i << 1) + 1; }
    static int rightChild(int i) { return (i << 1) + 2; }
    static Node createSubtree(int i, int[] nums) {
        if(i >= nums.length) return null;
        
        Node root = new Node(nums[i]);
        root.left = createSubtree(leftChild(i), nums);
        root.right = createSubtree(rightChild(i), nums);
        return root;
    }
    public static Node createTree(int[] nums){
        return createSubtree(0, nums);
    }
    static void inOrderTraversal(Node root, FileWriter output) throws IOException {
        if(root != null) {
            inOrderTraversal(root.left, output);
            output.write(root.data + " ");
            inOrderTraversal(root.right, output);
        }
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");
        
        int n = input.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; ++i)
            nums[i] = input.nextInt();

        Node root = createTree(nums);

        inOrderTraversal(root, output);

        input.close();
        output.close();
    }
}