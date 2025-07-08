import java.io.*;
import java.security.Key;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        int n = parseInt(br.readLine());
        while (n != -1) {
            int sum = 1;
            list.clear();
            for (int i = 2; i < n; i++) {
                if(n%i==0) {
                    sum += i;
                    list.add(i);
                }
            }

            if(sum==n) {
                System.out.print(n + " = 1");
                for (Integer i : list)
                    System.out.print(" + " + i);
            } else
                System.out.print(n + " is NOT perfect.");
            System.out.println();
            n = parseInt(br.readLine());
        }
    }
}