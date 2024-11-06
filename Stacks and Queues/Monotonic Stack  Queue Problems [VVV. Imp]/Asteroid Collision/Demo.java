import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    public static int[] asteroidCollision(int[] asteroids) {
        int[] stack = new int[asteroids.length];
        int top = -1;

        for (int asteroid : asteroids) {
            if (top == -1 || stack[top] < 0 || asteroid > 0)
                stack[++top] = asteroid;
            else {
                boolean asteroidExplode = false;
                do {
                    if (stack[top] < -asteroid)
                        --top;
                    else if (stack[top] > -asteroid) {
                        asteroidExplode = true;
                        break;
                    } else {
                        --top;
                        asteroidExplode = true;
                        break;
                    }
                } while (top != -1 && stack[top] > 0);

                if (!asteroidExplode)
                    stack[++top] = asteroid;
            }
        }

        int[] res = new int[top + 1];
        for (int i = 0; i <= top; ++i)
            res[i] = stack[i];

        return res;
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int N = input.nextInt();
        int[] nums = new int[N];
        for(int i = 0; i < N; ++i)
            nums[i] = input.nextInt();
        
        int[] res = asteroidCollision(nums);

        output.write(Arrays.toString(res));

        input.close();
        output.close();
    }
}