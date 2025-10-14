import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Node[] tree;
    static Deque<Node> stack = new ArrayDeque<>();
    static Map<Integer, Integer> map = new HashMap<>();

    static int[] inorder;
    static int[] postorder;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        tree = new Node[n + 1];

        inorder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        postorder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i <= n; i++)
            tree[i] = new Node(i);

        for (int i = 0; i < n; i++)
            map.put(inorder[i], i);

        int root = postorder[postorder.length - 1];
        Node parent = tree[root];

        divideAndConquer(null, 0, n-1, 0, n-1);

        stack.add(parent);

        //preorder 출력 순서 루트 -> 왼 -> 오
        //이렇게 하면 level 유지 되면서 루트는 바로 출력, 자식들은 preorder 순서에 맞춰서 다시 while문 반복
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            sb.append(node.number).append(" ");

            // 오른쪽 자식을 먼저 넣고, 왼쪽 자식을 나중에 넣음
            List<Node> children = node.children;
            for (int i = children.size() - 1; i >= 0; i--) {
                stack.push(children.get(i));
            }
        }

        System.out.println(sb);
    }

    public static class Node {
        int number;
        List<Node> children = new ArrayList<>();

        public Node(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }
    }

    public static void divideAndConquer(Node parent, int inorderStart, int inorderEnd, int postorderStart, int postorderEnd) {
        if (inorderStart > inorderEnd || postorderStart > postorderEnd)
            return;

        int root = postorder[postorderEnd];
        int rootIdx = map.get(root);

        if (parent != null)
            parent.children.add(tree[root]);

        int size = rootIdx - inorderStart;

        divideAndConquer(tree[root], inorderStart, rootIdx - 1, postorderStart, postorderStart + size - 1);
        divideAndConquer(tree[root], rootIdx + 1, inorderEnd, postorderStart + size, postorderEnd - 1);
    }
}


