import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] paper;

    static int plusOne;
    static int zero;
    static int minusOne;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        plusOne = 0;
        zero = 0;
        minusOne = 0;

        for (int i = 0; i < n; i++) {
            paper[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        devidePaper(0, 0, n);

        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(plusOne);
    }

    static void devidePaper(int x, int y, int n) {

        boolean isPlusOne = true;
        boolean isZero = true;
        boolean isMinusOne = true;


        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (paper[i][j] != 1) {
                    isPlusOne = false;
                    break;
                }
            }
            if (!isPlusOne)
                break;
        }

        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (paper[i][j] != 0) {
                    isZero = false;
                    break;
                }
            }
            if (!isZero)
                break;
        }

        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (paper[i][j] != -1) {
                    isMinusOne = false;
                    break;
                }
            }
            if (!isMinusOne)
                break;
        }

        if (!isPlusOne && !isZero && !isMinusOne) {
            devidePaper(x, y, n/3);
            devidePaper(x, y+n/3, n/3);
            devidePaper(x, y+(2*n/3), n/3);
            devidePaper(x+n/3, y, n/3);
            devidePaper(x+n/3, y+n/3, n/3);
            devidePaper(x+n/3, y+(2*n/3), n/3);
            devidePaper(x+(2*n/3), y, n/3);
            devidePaper(x+(2*n/3), y+n/3, n/3);
            devidePaper(x+(2*n/3), y+(2*n/3), n/3);
            return;
        }

        if (isPlusOne)
            plusOne++;

        if (isZero)
            zero++;

        if (isMinusOne)
            minusOne++;
    }
}
