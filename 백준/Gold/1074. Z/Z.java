import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int r;
    static int c;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        r = arr[1];
        c = arr[2];

        int length = (int) Math.pow(2, n);
        divide(0, 0, length);

        System.out.println(count);
    }

    public static void divide(int x, int y, int length) {
        int nextLength = length / 2;

        int sum = nextLength * nextLength;
        int nextX = 0;
        int nextY = 0;
        //1사분면 검사
        if (r < x + nextLength && c < y + nextLength) {
            nextX = x;
            nextY = y;
        }
        //2사분면 검사
        if (r < x + nextLength && c >= y + nextLength) {
            count += sum;
            nextX = x;
            nextY = y+nextLength;
        }
        //3사분면 검사
        if (r >= x + nextLength && c < y + nextLength) {
            count += 2 * sum;
            nextX = x+nextLength;
            nextY = y;
        }
        //4사분면 검사
        if (r >= x + nextLength && c >= y + nextLength) {
            count += 3 * sum;
            nextX = x + nextLength;
            nextY = y + nextLength;
        }

        if (nextLength == 0)
            return;

        divide(nextX, nextY, nextLength);
    }
}

