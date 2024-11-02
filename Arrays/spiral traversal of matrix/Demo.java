import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static List<Integer> spiralTraversal(int[][] arr) {
        
        List<Integer> list = new ArrayList<>();

        int top = 0;
        int left = 0;
        int bottom = arr.length-1;
        int right = arr[0].length-1;

        while(top <= bottom && left <= right) {
            for(int i = left; i <= right; ++i)
                list.add(arr[top][i]);
            top++;
            for(int i = top; i <= bottom; ++i)
                list.add(arr[i][right]);
            right--;
            if(top <= bottom) {
                for(int i = right; i >= left; --i) 
                    list.add(arr[bottom][i]);
                bottom--;
            }
            if(left <= right){
                for(int i = bottom; i >= top; --i)
                    list.add(arr[i][left]);
                left++;
            }
        }

        return list;  
    }
    
    public static void main(String[] args) throws IOException {
        File inputfile = new File("input.txt");
        Scanner input = new Scanner(inputfile);
        FileWriter output = new FileWriter("output.txt");

        int n = input.nextInt();
        int m = input.nextInt();

        int[][] arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++)
                arr[i][j] = input.nextInt();
        }

        List<Integer> list = spiralTraversal(arr);
        
        // System.out.println(list);
        for(int elem : list)
            output.write(Integer.toString(elem) + " ");

        input.close();
        output.close();
        
    }
}
