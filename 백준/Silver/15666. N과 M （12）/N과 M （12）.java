import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer> list;
    static int n;
    static int m;
    static int[] arr;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        m = arr[1];
        answer = new int[m];
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++)
            set.add(arr[i]);

        list = new ArrayList<>(set);
        Collections.sort(list);
        
        dfs(0, 0);
    }

    public static void dfs(int depth, int start) {
        if (depth == m) {
            for (int i = 0; i < m; i++)
                System.out.print(answer[i] + " ");
            System.out.println();
            return;
        }

        for(int i = start; i < list.size(); i++) {
            answer[depth] = list.get(i);
            dfs(depth + 1, i);
        }
    }
}


