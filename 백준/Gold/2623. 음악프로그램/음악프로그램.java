import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static List<Node> nodes = new ArrayList<>();
    static PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getNumber));
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0];
        int m = arr[1];

        for (int i = 0; i < n; i++) {
            nodes.add(new Node(i + 1));
        }

        for (int i = 0; i < m; i++) {
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int N = arr[0];
            for(int j = 1; j < N; j++) {
                Node parent = nodes.get(arr[j] - 1);
                Node child = nodes.get(arr[j+1] - 1);

                parent.children.add(child);
                child.parents.add(parent);
            }
        }

        for(Node node : nodes)
            if(node.parents.isEmpty())
                pq.add(node);

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            for(Node child : node.children){
                child.parents.remove(node);
                if(child.parents.isEmpty())
                    pq.add(child);
            }
            list.add(node.number);
        }

        if(list.size() == n)
            for(int i : list)
                sb.append(i).append("\n");
        else
            sb.append(0);

        System.out.println(sb);
    }

    public static class Node {
        int number;
        List<Node> parents = new ArrayList<>();
        List<Node> children = new ArrayList<>();

        public Node(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }
    }
}
