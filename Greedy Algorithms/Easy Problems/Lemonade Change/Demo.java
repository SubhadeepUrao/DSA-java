import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {

    public static boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;

        for(int bill : bills) {
            int net = bill - 5;
            
            while(net >= 10 && tens > 0) {
                net -= 10;
                --tens;
            }
            while(net >= 5 && fives > 0) {
                net -= 5;
                --fives;
            }
            
            if(net > 0) return false;

            if(bill == 5) ++fives;
            else if(bill == 10) ++tens;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int[] bills = new int[n];
        for(int i = 0; i < n; ++i)
            bills[i] = input.nextInt();
        
        boolean res = lemonadeChange(bills);
        
        output.write(Boolean.toString(res));
        
        input.close();
        output.close();
    }
}