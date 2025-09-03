import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Node> queue = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int a = 0;
    static int b = 0;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            queue.clear();
            visited = new boolean[10_001];
            sb.setLength(0);
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            a = arr[0];
            b = arr[1];

            visited[a] = true;
            queue.add(new Node(a, null, null));

            bfs();
        }
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int number = node.number;

            if(number == b) {
                while(node.parent!=null){
                    sb.append(node.commands);
                    node = node.parent;
                }
                System.out.println(sb.reverse());
                break;
            }

            int first_1 = number / 1000;
            int first_3 = number % 1000;

            int last_1 = number % 10;
            int last_3 = number / 10;

            int r = last_1*1000 + last_3;

            int l = first_3 * 10 + first_1;

            int d = (number * 2) % 10000;

            int s = (number == 0) ? 9999 : number - 1;

            if(!visited[d]) {
                visited[d] = true;
                queue.add(new Node(d, "D", node));
            }

            if(!visited[s]) {
                visited[s] = true;
                queue.add(new Node(s, "S", node));
            }

            if(!visited[r]) {
                visited[r] = true;
                queue.add(new Node(r, "R", node));
            }

            if(!visited[l]) {
                visited[l] = true;
                queue.add(new Node(l, "L", node));
            }
        }
    }

    public static class Node {
        int number;
        String commands;
        Node parent;

        public Node(int number, String commands, Node parent) {
            this.number = number;
            this.commands = commands;
            this.parent = parent;
        }
    }
}