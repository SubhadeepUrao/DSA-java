import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {

    public static int minCoins(int[] coins, int amount) {
        int n = coins.length;
        int cnt = 0;

        for(int i = n - 1; i >= 0; --i) {
            int quo = amount / coins[i];
            if(quo > 0) {
                cnt += quo;
                amount -= coins[i] * quo;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int[] coins = new int[n];
        for(int i = 0; i < n; ++i)
            coins[i] = input.nextInt();
        
        int value = input.nextInt();
        
        int res = minCoins(coins, value);
        
        output.write(Integer.toString(res));
        
        input.close();
        output.close();
    }
}