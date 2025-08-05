import com.sun.source.tree.Tree;

import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] queen;
    static StringBuilder sb = new StringBuilder();
    static int count = 0;
    static int n = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        queen = new boolean[n][n];
        dfs(0);
        System.out.println(count);
    }

    public static void dfs(int row) {
        if (row == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isQueen(row, i)) {
                queen[row][i] = true;
                dfs(row + 1);
                queen[row][i] = false;
            }
        }
    }

    public static boolean isQueen(int x, int y) {
        for (int k = 0; k < n; k++) {
            //세로 검사
            if (queen[k][y])
                return false;
            //대각선 검사
            int left = x - k;
            int right = x + k;
            int top = y + k;
            int bottom = y - k;
            //좌 상단
            if ((left >= 0 && left < n) && (top >= 0 && top < n))
                if (queen[left][top])
                    return false;
            //우 상단
            if ((right >= 0 && right < n) && (top >= 0 && top < n))
                if (queen[right][top])
                    return false;
            //좌 하단
            if ((left >= 0 && left < n) && (bottom >= 0 && bottom < n))
                if (queen[left][bottom])
                    return false;
            //우 하단
            if ((right >= 0 && right < n) && (bottom >= 0 && bottom < n))
                if (queen[right][bottom])
                    return false;
        }
        return true;
    }
}

