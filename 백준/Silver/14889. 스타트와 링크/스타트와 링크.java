import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int n = 0;
    static int[][] bonus;
    static Deque<Integer> teamA = new ArrayDeque<>();
    static Deque<Integer> teamB = new ArrayDeque<>();
    static int pointA = 0;
    static int pointB = 0;
    static int gap = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        bonus = new int[n][n];
        for (int i = 0; i < n; i++)
            bonus[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dfs(0);
        System.out.println(gap);
    }

    public static void dfs(int depth) {
        if (depth == n / 2) {
            teamB.clear();
            for (int i = 0; i < n; i++) {
                if (!teamA.contains(i)) {
                    teamB.add(i);
                }
            }

            pointA = 0;
            pointB = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (teamA.contains(i) && teamA.contains(j)) {
                        pointA += bonus[i][j];
                    }
                    if (teamB.contains(i) && teamB.contains(j)) {
                        pointB += bonus[i][j];
                    }
                }
            }
            gap = Math.min(gap, Math.abs(pointA - pointB));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (teamA.isEmpty())
                teamA.push(i);
            else {
                if (teamA.peek() < i)
                    teamA.push(i);
                else
                    continue;
            }
            dfs(depth + 1);
            teamA.pop();
        }
    }
}

