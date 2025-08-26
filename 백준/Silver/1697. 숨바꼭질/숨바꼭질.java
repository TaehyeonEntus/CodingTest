import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] visited;
    static Deque<Node> queue;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = arr[0];
        m = arr[1];

        queue = new ArrayDeque<>();
        visited = new boolean[100_001];

        queue.add(new Node(n,0));
        visited[n] = true;

        bfs();
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            int x = node.x;
            int count = node.count;
            if(x==m) {
                System.out.println(count);
                return;
            }

            if(x>0 && !visited[x-1]) {
                visited[x-1] = true;
                queue.add(new Node(x-1, count+1));
            }

            if(x<100_000 && !visited[x+1]) {
                visited[x+1] = true;
                queue.add(new Node(x+1, count+1));
            }

            if(x<=50_000 && !visited[2*x]) {
                visited[2*x] = true;
                queue.add(new Node(2*x, count+1));
            }
        }
    }

    public static class Node {
        int x;
        int count;

        public Node(int x,int count) {
            this.x = x;
            this.count = count;
        }
    }
}

