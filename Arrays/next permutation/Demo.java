import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Demo {
    public static void swap(ArrayList<Integer> permutation, int i, int j) {
		int temp = permutation.get(i);
		permutation.set(i, permutation.get(j));
		permutation.set(j, temp);
	}
	public static void reverse(ArrayList<Integer> permutation, int start, int end) {
		while(start < end) {
			swap(permutation, start, end);
			start++;
			end--;
		}
	}
	public static ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation) 
	{
		int n = permutation.size();
		for(int i = n-1; i > 0; --i) {
			if(permutation.get(i-1) < permutation.get(i)) {
				int j = i+1;
				int nextgreater = i;
				while(j < n && permutation.get(j) > permutation.get(i-1)) {
					nextgreater = j;
					j++;
				}
				if(nextgreater < n) {
					swap(permutation, i-1, nextgreater);
					reverse(permutation, i, n-1);
					return permutation;
				}
			}
		}
		System.out.println("fgd");
		reverse(permutation, 0, n-1);
		return permutation;
	}
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            arr.add(input.nextInt());
        }
        
        arr = nextPermutation(arr);
        for(int elem : arr) {
            output.write(Integer.toString(elem) + " ");
        }

        input.close();
        output.close();
        
    }
}
