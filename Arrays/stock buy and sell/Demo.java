import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    
    public static int stockBuySell(int[] arr) {
        int buy = arr[0];
        int maxProfit = 0;
        for(int elem : arr) {
            buy = Math.min(buy, elem); // we buy @min price
            maxProfit = Math.max(maxProfit, elem - buy); // we sell @max priceP
        }
        return maxProfit;
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
        
        output.write(Integer.toString(stockBuySell(arr)) + " ");

        input.close();
        output.close();
        
    }
}
