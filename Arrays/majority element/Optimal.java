// Boyer-Moore majority vote algorithm
// VOTING Algo
// If an current candidate is upvoted by oppositions, new candidate is selected.
// If the current candidate is the majority elem but still is upvoted, the candidate still
// holds to winning position because of its N/2 times presence in the array. Eventually,
// it will win when it will be supported frequently in the upcoming votes.


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Optimal {
    public static int findMajor(int[] arr, int val, int start) {
        int count = 0;
        for(int i = start; i < arr.length; ++i) {
            if(val == arr[i]) count++;
            else count--;
            if(count < 0) return findMajor(arr, arr[i], i);
        }
        return val;
    }
    public static int majorityElement(int[] arr) {
        return findMajor(arr, arr[0], 0);
    }
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        
        output.write(Integer.toString(majorityElement(arr)) + " ");

        input.close();
        output.close();
        
    }
}
