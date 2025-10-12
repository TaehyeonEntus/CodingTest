import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Set<Node> set = new HashSet<>();
    static Deque<Node> q = new ArrayDeque<>();
    static int n;
    static int l;
    static int r;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        l = arr[1];
        r = arr[2];
        map = new int[n][n];
        for(int i = 0; i < n; i++)
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int count = 0;
        while (bfs()){
            count++;
        }
        System.out.println(count);
    }

    public static boolean bfs() {
        boolean isMoved = false;
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;
                visited[i][j] = true;
                Node node = new Node(i, j);
                q.add(node);
                set.clear();
                while (!q.isEmpty()) {
                    Node cur = q.poll();
                    set.add(cur);
                    for (int dir = 0; dir < 4; dir++) {
                        int x = cur.x + dx[dir];
                        int y = cur.y + dy[dir];

                        if (x < 0 || x >= n || y < 0 || y >= n) continue;
                        if (visited[x][y]) continue;
                        if (Math.abs(map[x][y] - map[cur.x][cur.y]) < l || Math.abs(map[x][y] - map[cur.x][cur.y]) > r) continue;
                        visited[x][y] = true;
                        q.add(new Node(x, y));
                        isMoved = true;
                    }
                }
                int sum = 0;
                for (Node num : set)
                    sum += map[num.x][num.y];
                sum /= set.size();
                for (Node num : set)
                    map[num.x][num.y] = sum;
            }
        return isMoved;
    }

    public static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
