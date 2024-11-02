import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Optimal1 {
    public static int[] findRepeatMissing(int[] arr) {
        long sum = 0;
        long sumSquares = 0;
        for(int elem: arr) {
            sum += elem;
            sumSquares += (long)elem * (long)elem;
        }
        
        long N = arr.length;
        long trueSum = N*(N+1)/2;
        long trueSumSquares = N*(N+1)*(2*N+1)/6;
        
        long C1 = sum - trueSum;
        long C2 = sumSquares - trueSumSquares;
        
        long x = (C2 / C1 + C1) / 2;
        long y = x - C1;

        int[] res = {(int)x, (int)y};

        return res;
    }
    
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        Scanner input = new Scanner(file);
        FileWriter output = new FileWriter("output.txt");


        int n = input.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; ++i) {
            arr[i] = input.nextInt();
        }

        int[] res = findRepeatMissing(arr);

        output.write(res[0] + " " + res[1]);
        

        input.close();
        output.close();
    }
}