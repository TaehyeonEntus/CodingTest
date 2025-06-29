import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n_m = br.readLine();
        String[] s = n_m.split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i+1);
        }

        for(int i = 0; i < m; i++) {
            String[] str = br.readLine().split(" ");
            int startIndex = Integer.valueOf(str[0])-1;
            int endIndex = Integer.valueOf(str[1]);

            Collections.reverse(list.subList(startIndex, endIndex));
        }

        for(int a : list){
            System.out.print(a+" ");
        }
    }
}