import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited1;
    static boolean[] visited2;
    static List<List<Integer>> graph;
    static Deque<Integer> queue;

    static List<Integer> answerDfs;
    static List<Integer> answerBfs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = line[0];
        int m = line[1];
        int startPoint = line[2] - 1;
        visited1 = new boolean[n];
        visited2 = new boolean[n];

        answerDfs = new ArrayList<>();
        answerBfs = new ArrayList<>();

        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = line[0] - 1;
            int b = line[1] - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 0; i < n; i++)
            graph.get(i).sort(Comparator.naturalOrder());

        queue.add(startPoint);
        visited1[startPoint] = true;
        answerBfs.add(startPoint+1);
        bfs();
        dfs(startPoint);

        for(int i : answerDfs)
            System.out.print(i+" ");
        System.out.println();

        for(int i : answerBfs)
            System.out.print(i+" ");
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            int num = queue.poll();
            for (int i : graph.get(num)) {
                if (!visited1[i]) {
                    queue.add(i);
                    answerBfs.add(i+1);
                    visited1[i] = true;
                }
            }
        }
    }

    public static void dfs(int a) {
        visited2[a] = true;
        answerDfs.add(a+1);
        for (int i : graph.get(a)) {
            if (!visited2[i]) {
                dfs(i);
            }
        }
    }
}

