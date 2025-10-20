import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Deque<Node> queue = new ArrayDeque<>();
    static int[] dp;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0];
        int k = arr[1];

        dp = new int[200_001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        queue.add(new Node(n, 0));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if(dp[cur.location] < cur.count)
                continue;
            
            dp[cur.location] = Math.min(dp[cur.location], cur.count);

            if (cur.location == k) {
                map.put(dp[k], map.getOrDefault(dp[k], 0) + 1);
                continue;
            }

            int plusOne = cur.location + 1;
            int minusOne = cur.location - 1;
            int mulTwo = cur.location * 2;

            int count = cur.count;

            if (plusOne < 200_001 && dp[plusOne] > dp[cur.location]) {
                queue.add(new Node(plusOne, count + 1));
            }
            if (minusOne >= 0 && dp[minusOne] > dp[cur.location]) {
                queue.add(new Node(minusOne, count + 1));
            }
            if (mulTwo < 200_001 && dp[mulTwo] > dp[cur.location]) {
                queue.add(new Node(mulTwo, count + 1));
            }
        }

        System.out.println(dp[k]);
        System.out.println(map.get(dp[k]));
    }

    public static class Node {
        int location;
        int count;

        public Node(int location, int count) {
            this.location = location;
            this.count = count;
        }
    }
}