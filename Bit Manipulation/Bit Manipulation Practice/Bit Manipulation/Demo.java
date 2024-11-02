import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Demo {
    public static ArrayList<Integer> bitManipulation(int num, int i) {
        ArrayList<Integer> list = new ArrayList<>();
        int temp = 1 << (i-1);
        if((num & temp) == 0) {
            list.add(0);
            list.add(num | temp);
            list.add(num);
        }
        else {
            list.add(1);
            list.add(num);
            list.add(num & ~temp);
        }
        return list;
    }
    public static void main(String[] args) throws IOException {
        File inputFile = new File("input.txt");
        Scanner input = new Scanner(inputFile);
        FileWriter output = new FileWriter("output.txt");

        int num = input.nextInt();
        int pos = input.nextInt();

        ArrayList<Integer> res = bitManipulation(num, pos);

        output.write(res.toString());

        input.close();
        output.close();
    }
}