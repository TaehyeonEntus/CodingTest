import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int v;
    static int e;
    static List<Node> graph = new ArrayList<>();
    static Deque<Node> queue = new ArrayDeque<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            graph.clear();
            queue.clear();
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            v = arr[0];
            e = arr[1];

            for (int j = 0; j < v + 1; j++)
                graph.add(new Node(j));

            visited = new boolean[v + 1];


            for (int j = 0; j < e; j++) {
                arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                graph.get(arr[0]).neighbors.add(graph.get(arr[1]));
                graph.get(arr[1]).neighbors.add(graph.get(arr[0]));
            }

            for(int j = 1; j<=v; j++){
                if(!visited[j]){
                    visited[j] = true;
                    queue.add(graph.get(j));
                    bfs();
                }
            }

            boolean isRight = true;
            for (int index = 1; index <= v; index++) {
                Node node = graph.get(index);

                for (Node neighbor : graph.get(index).neighbors) {
                    if (node.color == neighbor.color) {
                        isRight = false;
                        break;
                    }
                }
                if (!isRight) {
                    break;
                }
            }

            if (isRight)
                System.out.println("YES");
            else
                System.out.println("NO");

        }
    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (Node nextNode : graph.get(node.number).neighbors) {
                if (!visited[nextNode.number]) {
                    visited[nextNode.number] = true;
                    nextNode.color = !node.color;
                    queue.add(nextNode);
                }
            }
        }
    }

    public static class Node {
        int number;
        boolean color;
        List<Node> neighbors = new ArrayList<>();

        public Node(int number) {
            this.number = number;
        }

        public Node(int number, boolean color) {
            this.number = number;
            this.color = color;
        }
    }
}