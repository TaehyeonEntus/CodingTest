import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int answer = 0;
    static int n;
    static int x;
    static int y;
    static boolean[] visited;
    static int visited_count;
    static int[] langford;

    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];

        x = arr[1];
        y = arr[2];

        langford = new int[2 * n];
        langford[x - 1] = y - x - 1;
        langford[y - 1] = y - x - 1;

        visited = new boolean[n + 1];
        visited[y - x - 1] = true;
        visited_count = 1;

        dfs();

        System.out.println(answer);
    }


    public static void dfs() {
        if (visited_count == n) {
            answer++;
            return;
        }

        int k = -1;
        for (int i = 0; i < 2 * n; i++)
            if (langford[i] == 0) {
                k = i;
                break;
            }


        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                int left = k;
                int right = k + i + 1;

                if (right >= 2 * n)
                    return;

                if (langford[left] != 0 || langford[right] != 0)
                    continue;

                visited[i] = true;
                langford[left] = i;
                langford[right] = i;
                visited_count++;
                dfs();
                visited_count--;
                langford[left] = 0;
                langford[right] = 0;
                visited[i] = false;
            }
        }
    }
}