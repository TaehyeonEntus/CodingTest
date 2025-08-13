import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] paper;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        devideBlack(0, 0, n);

        System.out.println(sb);
    }

    static void devideBlack(int x, int y, int n) {

        boolean isBlack = true;
        boolean isWhite = true;


        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (paper[i][j] == 0) {
                    isBlack = false;
                    break;
                }
            }
            if (!isBlack)
                break;
        }

        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (paper[i][j] == 1) {
                    isWhite = false;
                    break;
                }
            }
            if (!isWhite)
                break;
        }

        if (!isBlack && !isWhite) {
            sb.append("(");
            devideBlack(x, y, n / 2);
            devideBlack(x, y + n / 2, n / 2);
            devideBlack(x + n / 2, y, n / 2);
            devideBlack(x + n / 2, y + n / 2, n / 2);
            sb.append(")");
            return;
        }

        if (isBlack)
            sb.append("1");

        if (isWhite)
            sb.append("0");
    }
}
