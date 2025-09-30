import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int m;
    static int length;
    static int[] buttons;
    static int minGap = 1_000_000;
    static int minLength = 1_000_000;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        if (m == 0) {
            if (n == 99 || n == 101)
                System.out.println(1);
            else if (n == 98 || n == 102)
                System.out.println(2);
            else if (n == 100)
                System.out.println(0);
            else
                System.out.println(String.valueOf(n).length());
            return;
        }
        length = String.valueOf(n).length();
        List<Integer> list = new ArrayList<>();

        int[] brokenButtons = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < 10; i++)
            list.add(i);

        for (int i : brokenButtons)
            list.remove(Integer.valueOf(i));

        buttons = list.stream().mapToInt(Integer::valueOf).toArray();
        Arrays.sort(buttons);

        for (int i : buttons)
            dfs(i, 0);

        int head = 10_000_000;
        int tail = 10_000_000;

        for (int i : buttons) {
            if (i != 0) {
                head = Math.min(head, i);
            }
            tail = Math.min(tail, i);
        }
        int k = head;
        for (int i = 0; i < length; i++) {
            k = k * 10 + tail;
        }



        int a = Math.abs(100 - n);
        int b = minLength + minGap;
        int c = Math.abs(k - n + length + 1);
        int answer = Math.min(a, b);

        answer = Math.min(answer, c);

        System.out.println(answer);
    }

    public static void dfs(int number, int depth) {
        if (depth > length)
            return;

        int gap = Math.abs(n - number);
        if (gap < minGap) {
            minGap = gap;
            minLength = (String.valueOf(number).length());
        }
        if (gap == minGap)
            minLength = Math.min(minLength, String.valueOf(number).length());
        for (int i : buttons) {
            dfs(number * 10 + i, depth + 1);
        }
    }
}