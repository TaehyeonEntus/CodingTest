import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] range = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i = range[0]; i <= range[1]; i++) {
            if(i == 1)
                continue;
            if(i == 2 || i == 3) {
                System.out.println(i);
                continue;
            }
            boolean isPrime = true;
            for(int j = 2; j <= Math.sqrt(i); j++){
                if(i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime)
                System.out.println(i);
        }
    }
}
