import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    
    public static int sqrtN(long N) {
		long lb = 1l;
		long ub = N;
		long mid;

		while(lb <= ub) {
			mid = (lb + ub) / 2;
			if(mid*mid <= N) lb = mid + 1;
			else ub = mid - 1;
		}
		return (int)ub;
	}
    
    
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int N = input.nextInt();

        int res = sqrtN(N);

        output.write(Integer.toString(res));

        input.close();
        output.close();
        
    }
}
