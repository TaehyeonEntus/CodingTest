import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        int min = arr[0];
        int max = arr[0];

        for(Integer i : arr) {
            if(i < min) {
                min = i;
            }
            if(i > max) {
                max = i;
            }
        }

        System.out.println(min*max);
    }
}

