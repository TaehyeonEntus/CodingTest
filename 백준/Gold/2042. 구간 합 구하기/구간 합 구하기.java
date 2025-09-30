import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int m;
    static int k;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = array[0];
        m = array[1];
        k = array[2];

        arr = new long[n];

        for (int i = 0; i < n; i++)
            arr[i] = Long.parseLong(br.readLine());

        for (int i = 0; i < m + k; i++) {
            long[] longArr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

            long a = longArr[0];
            long b = longArr[1];
            long c = longArr[2];

            if (a == 1)
                swap((int)b, c);
            else if (a == 2)
                sum((int)b, (int)c);
        }
        System.out.println(sb);
    }

    public static void swap(int index, long value) {
        arr[index - 1] = value;
    }

    public static void sum(int from, int to) {
        long sum = 0;
        for (int i = from - 1; i <= to - 1; i++)
            sum += arr[i];
        sb.append(sum).append("\n");
    }
}