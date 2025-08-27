import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++)
            list.add(Integer.parseInt(br.readLine()));

        Collections.sort(list);

        int listSize = list.size();
        int number = (int)Math.round(0.15 * listSize);
        int total = 0;
        for(int i = number; i < n-number; i++)
            total += list.get(i);

        System.out.println(Math.round((float)total/(listSize-(2*number))));
    }
}
