import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Demo {
    public static void swap(ArrayList<Integer> list, int i, int j) {
		int temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}
	public static void reverse(ArrayList<Integer> list, int start, int end) {
		while(start < end) {
			swap(list, start, end);
			start++;
			end--;
		}
	}
	public static ArrayList<Integer> findLeaders(int[] arr) 
	{
		ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;
        list.add(arr[n-1]);
        int last = 0;
        for(int i = n-2; i >= 0; --i) {
            if(list.get(last) < arr[i]) {
                list.add(arr[i]);
                ++last;
            }
        }
        reverse(list, 0, last);
        return list;
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
        
        ArrayList<Integer> list = findLeaders(arr);
        for(int elem : list) {
            output.write(Integer.toString(elem) + " ");
        }

        input.close();
        output.close();
        
    }
}
