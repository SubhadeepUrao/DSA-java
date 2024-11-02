import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashSet;

public class Demo {
    public static int longestConsecutiveSeq(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int elem : arr) {
            set.add(elem);
        }
        int longSeq = 0;
        for(int elem : arr) {
            if(set.isEmpty()) return longSeq;
            if(!set.contains(elem-1)) {
                int seq = 1;
                set.remove(elem);
                while(set.contains(++elem)) {
                    set.remove(elem);
                    ++seq;
                }
                longSeq = Math.max(longSeq, seq);
            }
        }
        return longSeq;
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
        
        int longSeq = longestConsecutiveSeq(arr);
        output.write(Integer.toString(longSeq) + " ");

        input.close();
        output.close();
        
    }
}
