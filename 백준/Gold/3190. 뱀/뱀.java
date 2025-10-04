import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Deque<Node> snake = new ArrayDeque<Node>();
    static Map<Integer, String> turnMap = new HashMap<Integer, String>();
    static int curDir = 1;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        snake.add(new Node(1, 1));
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map[arr[0]][arr[1]] = 1;
        }
        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            String[] arr = br.readLine().split(" ");
            turnMap.put(Integer.parseInt(arr[0]), arr[1]);
        }

        int second = 1;
        while (true) {
            Node head = snake.peekLast();

            int next_x = head.x;
            int next_y = head.y;

            if (curDir == 0) {
                next_x--;
            } else if (curDir == 1) {
                next_y++;
            } else if (curDir == 2) {
                next_x++;
            } else if (curDir == 3) {
                next_y--;
            }

            if (next_x < 1 || next_y < 1 || next_x > n || next_y > n)
                break;

            Node next = new Node(next_x, next_y);

            if (snake.contains(next))
                break;

            if (map[next_x][next_y] == 1) {
                snake.add(next);
                map[next_x][next_y] = 0;
            } else {
                snake.poll();
                snake.add(next);
            }

            if (turnMap.containsKey(second)) {
                String flag = turnMap.get(second);
                if (flag.equals("L"))
                    turnLeft();
                else
                    turnRight();
            }
            second++;
        }
        System.out.println(second);
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;
            Node node = (Node) object;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void turnLeft() {
        curDir--;
        if (curDir == -1)
            curDir = 3;
    }

    public static void turnRight() {
        curDir++;
        if (curDir == 4)
            curDir = 0;
    }
}
