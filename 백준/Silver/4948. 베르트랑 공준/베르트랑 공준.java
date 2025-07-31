import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            int count = 0;
            for (int i = n+1; i <= 2*n; i++) {
                if (i == 1)
                    continue;
                if (i == 2 || i == 3) {
                    count++;
                    continue;
                }
                boolean isPrime = true;
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime)
                    count++;
            }
            System.out.println(count);
        }
    }
}
