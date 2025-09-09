import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Node> queue = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int m;
    static boolean[] visited;
    static Node[] nodes;
    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        m = arr[1];
        nodes = new Node[n+1];
        visited = new boolean[n+1];
        for(int i = 0; i < n+1; i++){
            nodes[i] = new Node(i);
        }

        for(int i = 0; i < m; i++){
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = arr[0];
            int b = arr[1];
            nodes[b].isFrontOf(nodes[a]);
        }

        for(int i = 1; i<n+1; i++){
            if(nodes[i].parents.isEmpty()){
                visited[i] = true;
                queue.add(nodes[i]);
                for(Node node : nodes[i].children)
                    node.parents.remove(nodes[i]);
            }
        }

        bfs();

        System.out.println(sb.toString());
    }

    public static void bfs(){
        while(!queue.isEmpty()){
            Node node = queue.poll();
            sb.append(node.number).append(" ");
            for(Node child : node.children){
                if(child.parents.isEmpty() && !visited[child.number]){
                    visited[child.number] = true;
                    queue.add(child);
                    for(Node next : child.children)
                        next.parents.remove(child);
                }
            }
        }

        for(int i = 1; i<n+1; i++){
            if(!visited[i]){
                sb.append(nodes[i].number).append(" ");
            }
        }
    }

    public static class Node{
        int number;

        List<Node> parents = new ArrayList<>();
        List<Node> children = new ArrayList<>();

        public Node(int number) {
            this.number = number;
        }

        public int getDegree(){
            return parents.size();
        }

        public void isFrontOf(Node n){
            parents.add(n);
            n.children.add(this);
        }
    }
}