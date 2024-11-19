import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    public static int findContentChildren(int[] greed, int[] cookieSize) {
        Arrays.sort(greed);
        Arrays.sort(cookieSize);
        
        int i = 0;
        int j = 0;
        int n = greed.length;
        int m = cookieSize.length;

        while(i < n && j < m) {
            if(greed[i] <= cookieSize[j]) ++i;
            ++j;
        }

        return i;
    }

    // public static int findContentChildren(int[] g, int[] s) {
    //     Arrays.sort(g);
    //     Arrays.sort(s);
    //     int i = 0;
    //     int j = 0;

    //     while(i < g.length) {
    //         while(j < s.length && g[i] > s[j]) {
    //             ++j;
    //         }
    //         if(j == s.length) return i;
    //         ++j;
    //         ++i;
    //     }
    //     return i;
    // }
    
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int[] greed = new int[n];
        for(int i = 0; i < n; ++i)
            greed[i] = input.nextInt();

        int m = input.nextInt();
        int[] size = new int[m];
        for(int i = 0; i < m; ++i)
            size[i] = input.nextInt();
        
        int res = findContentChildren(greed, size);
        
        output.write(Integer.toString(res));
        
        input.close();
        output.close();
    }
}