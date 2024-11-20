import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

// Same as Maximum Length of Pair Chain
public class Demo {
    public static int maxMeetings(int start[], int end[]) {
        
        int[][] pair = new int[start.length][2];
        for(int i = 0; i < start.length; ++i) {
            pair[i] = new int[]{ start[i], end[i] };
        }
        
        Arrays.sort(pair, (a, b) -> Integer.compare(a[1], b[1]));
        
        int limit = -1;
        int cnt = 0;
        for(int[] curr : pair) {
            if(limit < curr[0]) {
                limit = curr[1];
                ++cnt;
            }
        }
        return cnt;
    }
    
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int[] start = new int[n];
        for(int i = 0; i < n; ++i)
            start[i] = input.nextInt();

        int[] end = new int[n];
        for(int i = 0; i < n; ++i)
            end[i] = input.nextInt();
        
        int res = maxMeetings(start, end);
        
        output.write(Integer.toString(res));
        
        input.close();
        output.close();
    }
}