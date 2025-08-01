import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            long x = 1;
            long answer = 1;
            String[] s = br.readLine().split(" ");
            long A = Long.parseLong(s[0]);
            long B = Long.parseLong(s[1]);
            for(int j = 0; j < A; j++) {
                answer *= B--;
                answer /= x++;
            }
            System.out.println(answer);
        }
    }
}

