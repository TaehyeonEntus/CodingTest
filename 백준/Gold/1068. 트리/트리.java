import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static List<Node> list = new ArrayList<>();
    static Deque<Node> queue = new ArrayDeque<>();
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < n; i++)
            list.add(new Node(i));
        int root = -1;

        for(int i = 0; i < n; i++) {
            int child = i;
            int parent = arr[i];
            if(parent == -1) {
                root = i;
                continue;
            }
            list.get(child).parent = list.get(parent);
            list.get(parent).children.add(list.get(child));
        }


        Node target = list.get(Integer.parseInt(br.readLine()));
        if(target.number != root)
            target.parent.children.remove(target);
        else{
            System.out.println(0);
            return;
        }

        queue.add(list.get(root));
        int leaf = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.children.isEmpty())
                leaf++;
            else
                queue.addAll(node.children);
        }
        System.out.println(leaf);
    }

    public static class Node {
        int number;
        Node parent = null;
        List<Node> children = new ArrayList<>();

        public Node(int number) {
            this.number = number;
        }
    }
}


