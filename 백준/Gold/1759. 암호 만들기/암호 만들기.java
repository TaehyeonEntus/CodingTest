import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static String[] arr;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = temp[0];
        m = temp[1];

        arr = br.readLine().split(" ");
        Arrays.sort(arr);

        dfs(0, 0, "", 0, 0);

        System.out.println(sb);
    }

    public static void dfs(int depth, int start, String str, int C, int V) {
        if (depth == n) {
            if (C >= 2 && V >= 1)
                sb.append(str).append('\n');
            return;
        }
        for (int i = start; i < m; i++) {
            if (arr[i].equals("a") || arr[i].equals("e") || arr[i].equals("i") || arr[i].equals("o") || arr[i].equals("u"))
                dfs(depth + 1, i + 1, str + arr[i], C, V + 1);
            else
                dfs(depth + 1, i + 1, str + arr[i], C + 1, V);
        }
    }
}
