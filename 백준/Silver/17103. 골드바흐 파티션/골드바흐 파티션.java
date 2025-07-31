import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] primeArray = new boolean[1000000+1];
        Arrays.fill(primeArray, true);
        primeArray[0] = false;
        primeArray[1] = false;
        primeArray[2] = true;
        primeArray[3] = true;
        for(int i = 2; i <= Math.sqrt(1000000); i++) {
            for(int j = i*i; j <= 1000000; j+=i) {
                primeArray[j] = false;
            }
        }
        for(int i = 0; i<n;i++){
            int count = 0;
            int sum = Integer.parseInt(br.readLine());
            int a = 2;
            int b = sum-a;
            while (true){
                if(a>b)
                    break;
                if(primeArray[a]&&primeArray[b]) {
                    count++;
                }
                a++;
                b--;
            }
            System.out.println(count);
        }
    }
}
