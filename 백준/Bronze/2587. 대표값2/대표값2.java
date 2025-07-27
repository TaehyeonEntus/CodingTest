import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += list.get(i);
        }
        int avg = sum / 5;
        int middle = list.get(2);
        System.out.println(avg);
        System.out.println(middle);
    }
}