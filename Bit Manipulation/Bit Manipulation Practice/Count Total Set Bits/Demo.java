import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {

    // public static int countSetBits(int num){
    //     if(num == 0) return 0;
        
    //     int n = 1;
    //     int cnt = 0;
        
    //     while(num >= n) {
    //         cnt++;
    //         n = n << 1;
    //     }
    //     n >>= 1;
    //     cnt = --cnt * (n >> 1); // p * 2^(p-1)
    //     cnt += num - n + 1; // N - 2^p + 1
        
    //     return cnt + countSetBits(num - n); // rec(N - 2^p)
    // }

    public static int countSetBits(int n)
    {
        //Ignoring 0 as all the bits are unset. 
        n+=1;
        int count=0;
        
        //Counting set bits from 1 to n.
        for( int x=2 ; x/2<n ; x=x*2 )
        {
            //Total count of pairs of 0s and 1s.
            int quotient = n/x;
            //quotient gives the complete count of pairs of 1s.
            //Multiplying it with the (current power of 2)/2 will give
            //the count of 1s in the current bit.
            count += quotient * x / 2;
            
            int remainder = n%x;
            //If the count of pairs is odd then we add the remaining 1s 
            //which could not be grouped together. 
            if(remainder > x/2)
                count += remainder - x/2;
        }
        
        //returning count of set bits.
        return count;
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int num = input.nextInt();

        int res = countSetBits(num);

        output.write(Integer.toString(res));

        input.close();
        output.close();
    }
}