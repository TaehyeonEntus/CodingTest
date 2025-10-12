import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Node> closeFishQueue = new PriorityQueue<>(Comparator.comparingInt(Node::getDistance).thenComparingInt(Node::getX).thenComparingInt(Node::getY));
    static PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getDistance));
    static int n;
    static int babyShark = 2;
    static int fishCount = 0;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++)
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int count = 0;

        int dist = bfs();
        while (dist != 0) {
            count += dist;
            dist = bfs();
        }
        System.out.println(count);
    }

    public static int bfs() {
        pq.clear();
        closeFishQueue.clear();

        int sharkX = -1, sharkY = -1;
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                }
            }

        visited[sharkX][sharkY] = true;
        pq.add(new Node(sharkX, sharkY, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            for (int dir = 0; dir < 4; dir++) {
                int x = cur.x + dx[dir];
                int y = cur.y + dy[dir];

                if (x < 0 || y < 0 || x >= n || y >= n) continue;
                if (visited[x][y]) continue;
                visited[x][y] = true;

                if (map[x][y] <= babyShark) {
                    Node newNode = new Node(x, y, cur.distance + 1);
                    if (map[x][y] != 0 && map[x][y] < babyShark)
                        closeFishQueue.add(newNode);
                    pq.add(newNode);
                }
            }
        }

        if(closeFishQueue.isEmpty()) return 0;

        Node fish = closeFishQueue.poll();
        map[sharkX][sharkY] = 0;
        map[fish.x][fish.y] = 9;
        fishCount++;
        if(fishCount == babyShark){
            fishCount = 0;
            babyShark++;
        }
        return fish.distance;
    }

    public static class Node {
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        public int getDistance() {
            return distance;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
