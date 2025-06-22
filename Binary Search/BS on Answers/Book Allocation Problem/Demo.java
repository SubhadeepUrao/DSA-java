import java.util.ArrayList;
import java.util.Arrays;
import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Demo {
    public static boolean valid(ArrayList<Integer> books, int n, int m, int maxPage) {
        int total = 0;
        for(int pages: books) {
            if(pages > maxPage) return false;
            total += pages;
            if(total > maxPage) {
                total = pages;
                --m;
            }
        }
        // if(total <= maxPage) --m;
        --m;
        if(m >= 0) return true;
        return false;
    }
    public static int findPages(ArrayList<Integer> books, int n, int m) {
        if(n < m) return -1;
        int mini = 0;
        int maxi = 0;

        for(int pages: books) {
            mini = Math.max(mini, pages);
            maxi += pages;
        }

        int lb = mini;
        int ub = maxi;
        int mid;

        while(lb <= ub) {
            mid = (lb + ub) / 2;
            if(valid(books, n, m, mid)) ub = mid - 1;
            else lb = mid + 1;
        }
        return lb;
    }
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int m = input.nextInt();

        int[] books = new int[n];
        for(int i = 0; i < n; ++i)
            books[i] = input.nextInt();

        
        int res = findPages(Arrays.stream(books).boxed().collect(Collectors.toCollection(ArrayList::new)), n, m);

        output.write(Integer.toString(res));

        input.close();
        output.close();
        
    }
}