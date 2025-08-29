import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Node> queue = new ArrayDeque<>();
    static int n;
    static int[][] map;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++)
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        queue.add(new Node(0,1,0));
        bfs();

        System.out.println(count);
    }

    public static void bfs() {
        //dir 0 -> 가로, 1 -> 세로, 2 -> 대각선
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int curX = currentNode.x;
            int curY = currentNode.y;
            int curDir = currentNode.dir;
            if (curX == n-1 && curY == n-1) {
                count++;
                continue;
            }
            //가로
            if (curDir == 0) {
                if(garoPossible(curX, curY)){
                    queue.add(new Node(curX, curY+1, 0));
                }
                if(daegakPossible(curX, curY)){
                    queue.add(new Node(curX+1, curY+1, 2));
                }
            }
            //세로
            else if (curDir == 1) {
                if(seroPossible(curX, curY)){
                    queue.add(new Node(curX+1, curY, 1));
                }
                if(daegakPossible(curX, curY)){
                    queue.add(new Node(curX+1, curY+1, 2));
                }
            }
            //대각
            else {
                if(garoPossible(curX, curY)){
                    queue.add(new Node(curX, curY+1, 0));
                }
                if(seroPossible(curX, curY)){
                    queue.add(new Node(curX+1, curY, 1));
                }
                if(daegakPossible(curX, curY)){
                    queue.add(new Node(curX+1, curY+1, 2));
                }
            }
        }
    }

    public static boolean seroPossible(int x, int y) {
        return x <= n - 2 && map[x + 1][y] != 1;
    }

    public static boolean garoPossible(int x, int y) {
        return y <= n - 2 && map[x][y + 1] != 1;
    }

    public static boolean daegakPossible(int x, int y) {
        return garoPossible(x, y) && seroPossible(x, y) && (map[x + 1][y + 1] != 1);
    }

    public static class Node {
        int x;
        int y;
        int dir;

        public Node(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}


