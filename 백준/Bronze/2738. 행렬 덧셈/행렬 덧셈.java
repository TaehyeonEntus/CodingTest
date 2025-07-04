import java.io.*;
import java.security.Key;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] string = br.readLine().split(" ");
        int n = parseInt(string[0]);
        int m = parseInt(string[1]);
        int[][] a = new int[n][m];

        for(int i = 0; i < n; i++) {
            string = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                a[i][j] = parseInt(string[j]);
            }
        }
        for(int i = 0; i < n; i++) {
            string = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                a[i][j] += parseInt(string[j]);
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

    }
}