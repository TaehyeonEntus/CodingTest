import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Node> queue = new ArrayDeque<>();
    //height, sero, garo
    static int[][][] map;
    static boolean[][][] visited;
    static int count = 0;

    static int Height;
    static int X;
    static int Y;

    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Height = arr[2];
        X = arr[0];
        Y = arr[1];

        map = new int[Height][Y][X];
        visited = new boolean[Height][Y][X];
        for (int h = 0; h < Height; h++) {
            for (int s = 0; s < Y; s++) {
                map[h][s] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int g = 0; g < X; g++) {
                    if (map[h][s][g] == 1 || map[h][s][g] == -1) {
                        visited[h][s][g] = true;
                        count++;
                    }
                    if (map[h][s][g] == 1)
                        queue.add(new Node(h, s, g, 0));
                }
            }
        }

        //시작 전 모두 익어 있는 경우
        if (count == Height * X * Y) {
            System.out.println("0");
            return;
        }

        int answer = bfs();

        //모두 익지 못하는 상황
        if (count != Height * X * Y) {
            System.out.println("-1");
            return;
        }

        System.out.println(answer);
    }

    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static int bfs() {
        int maxDay = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            maxDay = Math.max(maxDay, node.day);
            for (int dir = 0; dir < 6; dir++) {
                int x = node.garo + dx[dir];
                int y = node.sero + dy[dir];
                int height = node.height + dz[dir];
                if (x >= 0 && x < X && y >= 0 && y < Y && height >= 0 && height < Height) {
                    if(!visited[height][y][x]) {
                        count++;
                        visited[height][y][x] = true;
                        queue.add(new Node(height, y, x, node.day+1));
                    }
                }
            }
        }

        return maxDay;
    }

    public static class Node {
        int garo;
        int sero;
        int height;
        int day;

        public Node(int height, int sero, int garo, int day) {
            this.garo = garo;
            this.sero = sero;
            this.height = height;
            this.day = day;
        }
    }
}