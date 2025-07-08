import java.io.*;
import java.security.Key;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int sum = n;

        for (String s : str) {
            int num = Integer.parseInt(s);
            if(num == 1)
                sum--;
            for (int i = 2; i < num; i++)
                if (num % i == 0) {
                    sum--;
                    break;
                }
        }
        System.out.println(sum);
    }
}