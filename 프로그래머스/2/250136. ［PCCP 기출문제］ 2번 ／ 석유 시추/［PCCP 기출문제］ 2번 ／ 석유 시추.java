import java.util.Deque;
import java.util.ArrayDeque;
import java.util.*;

class Solution {
    static boolean[][] visited;
    static int[][] map;
    static Deque<Node> queue = new ArrayDeque<>();
    static int maxX;
    static int maxY;
    static int count = 0;

    public int solution(int[][] land) {
        int x = land.length;
        int y = land[0].length;
        maxX = x;
        maxY = y;
        map = land;
        int max = 0;
        visited = new boolean[x][y];
        List<OilCluster> list = new ArrayList<>();
        for (int j = 0; j < maxY; j++) {
            for (int i = 0; i < maxX; i++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    queue.add(new Node(i, j));
                    list.add(bfs());
                }
            }
        }
        int[] oilInColumn = new int[maxY];

        for (OilCluster oc : list) {
            for (int col : oc.cols) {
                oilInColumn[col] += oc.size;
            }
        }

        for (int val : oilInColumn) {
            if (val > max) max = val;
        }
        return max;
    }

    public static OilCluster bfs() {
        Set<Integer> set = new HashSet<>();
        int size = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            if (!visited[x][y]) {
                visited[x][y] = true;
                size++;
                set.add(y);

                if (x > 0 && map[x - 1][y] == 1)
                    queue.add(new Node(x - 1, y));

                if (x < (maxX - 1) && map[x + 1][y] == 1)
                    queue.add(new Node(x + 1, y));

                if (y > 0 && map[x][y - 1] == 1)
                    queue.add(new Node(x, y - 1));

                if (y < (maxY - 1) && map[x][y + 1] == 1)
                    queue.add(new Node(x, y + 1));
            }
        }
        return new OilCluster(size, set);
    }


    public static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class OilCluster {
        int size;
        Set<Integer> cols;

        public OilCluster(int size, Set<Integer> cols) {
            this.size = size;
            this.cols = cols;
        }
    }
}