import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = n / 3;
        int a = 1;
        char[][] chars = new char[n][n];
        boolean[][] isBlank = new boolean[m][m];
        while (a <= m) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    if (((i / a) % 3 == 1) && ((j / a) % 3 == 1)) {
                        isBlank[i][j] = true;
                    }
                }
            }
            a *= 3;
        }
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < m; y++) {
                int i = 3 * x;
                int j = 3 * y;
                if (isBlank[x][y]) {
                    chars[i][j] = ' ';
                    chars[i][j + 1] = ' ';
                    chars[i][j + 2] = ' ';
                    chars[i + 1][j] = ' ';
                    chars[i + 1][j + 1] = ' ';
                    chars[i + 1][j + 2] = ' ';
                    chars[i + 2][j] = ' ';
                    chars[i + 2][j + 1] = ' ';
                    chars[i + 2][j + 2] = ' ';
                } else {
                    chars[i][j] = '*';
                    chars[i][j + 1] = '*';
                    chars[i][j + 2] = '*';
                    chars[i + 1][j] = '*';
                    chars[i + 1][j + 1] = ' ';
                    chars[i + 1][j + 2] = '*';
                    chars[i + 2][j] = '*';
                    chars[i + 2][j + 1] = '*';
                    chars[i + 2][j + 2] = '*';
                }
            }
        }
        for (char[] charArr : chars) {
            System.out.println(charArr);
        }
    }
}

