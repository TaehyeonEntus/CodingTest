import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Node[] nodes;
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
        int cmp = Integer.compare(a.getIndegree(), b.getIndegree());
        if (cmp == 0) {
            throw new IllegalArgumentException();
        }
        return cmp;
    });

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            sb.setLength(0);
            pq.clear();
            int n = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            nodes = new Node[n + 1];
            nodes[0] = new Node(0);
            for (int j = 1; j <= n; j++)
                nodes[j] = new Node(arr[j - 1]);

            //위상 정렬
            for (int j = 1; j <= n; j++) {
                for (int a = 1; a < j; a++)
                    nodes[j].parents.add(nodes[a]);
                for (int b = j + 1; b <= n; b++)
                    nodes[j].children.add(nodes[b]);
            }

//            for(int j = 1; j <= n; j++){
//                Node node = nodes[j];
//                System.out.println(node.number);
//                System.out.print("parent = [ ");
//                for(Node parent : node.parents){
//                    System.out.print(parent.number+" ");
//                }
//                System.out.println("]");
//                System.out.print("child = [ ");
//                for(Node child : node.children){
//                    System.out.print(child.number+" ");
//                }
//                System.out.println("]");
//            }

            //등수 바꾸는 로직
            int m = Integer.parseInt(br.readLine());
            for (int j = 0; j < m; j++) {
                int[] a_b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                Node emptyNode = new Node(0);
                Node nodeA = emptyNode;
                Node nodeB = emptyNode;
                for (Node node : nodes) {
                    if (node.number == a_b[0]) {
                        nodeA = node;
                    } else if (node.number == a_b[1]) {
                        nodeB = node;
                    }
                }

                //nodeA가 더 높은 등수
                if (nodeA.children.contains(nodeB)) {
                    nodeA.children.remove(nodeB);
                    nodeB.parents.remove(nodeA);

                    nodeA.parents.add(nodeB);
                    nodeB.children.add(nodeA);
                }
                //nodeB가 더 높은 등수
                else if (nodeB.children.contains(nodeA)) {
                    nodeB.children.remove(nodeA);
                    nodeA.parents.remove(nodeB);

                    nodeB.parents.add(nodeA);
                    nodeA.children.add(nodeB);
                }
            }

//            for(int j = 1; j <= n; j++){
//                Node node = nodes[j];
//                System.out.println(node.number);
//                System.out.print("parent = [ ");
//                for(Node parent : node.parents){
//                    System.out.print(parent.number+" ");
//                }
//                System.out.println("]");
//                System.out.print("child = [ ");
//                for(Node child : node.children){
//                    System.out.print(child.number+" ");
//                }
//                System.out.println("]");
//            }
            try {
                for (int j = 1; j <= n; j++) {
                    pq.add(nodes[j]);
                }

                while (!pq.isEmpty()) {
                    Node node = pq.poll();
                    for (Node child : node.children) {
                        child.parents.remove(node);
                    }
                    sb.append(node.number).append(" ");

                }
                sb.append("\n");
            } catch (IllegalArgumentException e) {
                sb.setLength(0);
                sb.append("IMPOSSIBLE\n");
            }
            System.out.print(sb);
        }
    }

    public static class Node {
        int number;

        List<Node> parents = new ArrayList<>();
        List<Node> children = new ArrayList<>();

        public Node(int number) {
            this.number = number;
        }

        public int getIndegree() {
            return parents.size();
        }
    }
}