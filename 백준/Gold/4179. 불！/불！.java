import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getCount));
    static PriorityQueue<Node> firePQ = new PriorityQueue<>(Comparator.comparingInt(Node::getCount));
    static int n;
    static int m;
    static char[][] map;
    static boolean[][] visited;
    static boolean[][] fire_visited;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        m = arr[1];

        map = new char[n][m];

        fire_visited = new boolean[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++)
            map[i] = br.readLine().toCharArray();

        int answer = bfs();
        System.out.println(answer==0?"IMPOSSIBLE":answer);
    }

    public static int bfs() {
        int x = -1;
        int y = -1;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (map[i][j] == 'J') {
                    x = i;
                    y = j;
                } else if(map[i][j] == 'F'){
                    fire_visited[i][j] = true;
                    firePQ.add(new Node(i,j,0));
                }

        visited[x][y] = true;
        pq.add(new Node(x, y, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            while (!firePQ.isEmpty() && firePQ.peek().getCount() < node.getCount()){
                Node fireNode = firePQ.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = fireNode.x + dx[i];
                    int ny = fireNode.y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                        continue;

                    if (fire_visited[nx][ny])
                        continue;
                    if (map[nx][ny] != '#'){
                        map[nx][ny] = 'F';
                        fire_visited[nx][ny] = true;
                        firePQ.add(new Node(nx, ny, fireNode.getCount() + 1));
                    }
                }
            }
            if(map[node.x][node.y] == 'F')
                continue;
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    return node.getCount()+1;
                }

                if (visited[nx][ny])
                    continue;
                if (map[nx][ny] == 'F' || map[nx][ny] == '#')
                    continue;

                visited[nx][ny] = true;
                pq.add(new Node(nx, ny, node.count + 1));
            }
        }
        return 0;
    }

    public static class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        public int getCount() {
            return count;
        }
    }
}
