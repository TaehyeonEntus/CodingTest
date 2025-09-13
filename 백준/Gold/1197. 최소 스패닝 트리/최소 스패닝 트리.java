import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getC));
    static int[] root;

    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0];
        int m = arr[1];
        root = new int[n + 1];
        for (int i = 0; i <= n; i++)
            root[i] = i;

        for (int i = 0; i < m; i++) {
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = arr[0];
            int b = arr[1];
            int c = arr[2];
            pq.add(new Pair(a, b, c));
        }

        int total = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();

            int a = pair.a;
            int b = pair.b;
            int c = pair.c;
            
            if (unionFind(a, b))
                total += c;
        }
        System.out.println(total);
    }

    public static int findRoot(int num) {
        if (root[num] == num)
            return num;
        return root[num] = findRoot(root[num]);
    }

    public static boolean unionFind(int a, int b) {
        int rootA = findRoot(a);
        int rootB = findRoot(b);

        if (rootA == rootB) {
            return false;
        } else {
            root[rootA] = rootB;
            return true;
        }
    }

    public static class Pair {
        int a;
        int b;
        int c;

        public Pair(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public int getC() {
            return c;
        }
    }
}