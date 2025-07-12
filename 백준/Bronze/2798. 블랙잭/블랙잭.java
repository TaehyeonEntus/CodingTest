import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int max = 0;
        String[] cards = br.readLine().split(" ");
        List<Integer> list = new ArrayList<>();
        for(String card : cards) {
            list.add(Integer.parseInt(card));
        }
        for(int i = 0; i < n; i++) {
            int a = list.get(i);
            for(int j = 0; j < n; j++) {
                if(j==i)
                    continue;
                int b = list.get(j);
                for(int k = 0; k < n; k++) {
                    if(k==j || k==i)
                        continue;
                    int c = list.get(k);
                    int sum = a+b+c;
                    if(sum<=m)
                        max = Math.max(max,sum);
                }
            }
            if(max==m)
                break;
        }
        System.out.println(max);
    }
}