import java.io.*;
import java.security.Key;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = parseInt(br.readLine());
        int n = parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i = m; i <= n; i++) {
            if(i==1)
                continue;
            boolean isPrime = true;
            for(int j = 2; j < i; j++) {
                if(i%j==0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                list.add(i);
            }
        }
        int min = list.size()!=0?list.get(0):-1;
        int sum = 0;
        for(Integer i : list) {
            sum += i;
        }
        if(sum != 0) {
            System.out.println(sum);
            System.out.println(min);
        }
        else System.out.println("-1");
    }
}