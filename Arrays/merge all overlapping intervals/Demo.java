import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Demo {

    public static List<List<Integer>> mergeOverlappingIntervals(int [][]arr) {

        List<List<Integer>> list = new ArrayList<>();

        Comparator<int[]> cmp = (obj1,obj2) -> obj1[0] - obj2[0];

        Arrays.sort(arr, cmp);

        for(int[] row: arr) {
            if(list.isEmpty() || row[0] > list.get(list.size() - 1).get(1))
                list.add(Arrays.asList(row[0], row[1]));
            else 
                list.get(list.size() - 1).set(1, Math.max(row[1], list.get(list.size() - 1).get(1)));
        }
        return list; 
    }
    public static void main(String[] args) throws IOException {
        File file = new File("input.txt");
        Scanner input = new Scanner(file);
        FileWriter output = new FileWriter("output.txt");

        int rows = input.nextInt();

        int[][] arr = new int[rows][2];

        for(int i = 0; i < rows; ++i) {
            for(int j = 0; j < 2; ++j) {
                arr[i][j] = input.nextInt();
            }
        }
        List<List<Integer>> resList = mergeOverlappingIntervals(arr);

        for(List<Integer> row: resList) {
            output.write(row.get(0) + " " + row.get(1) + "\n");
        }

        input.close();
        output.close();
    }
}