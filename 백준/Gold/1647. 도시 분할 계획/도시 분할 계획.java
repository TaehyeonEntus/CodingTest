import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Road> pq = new PriorityQueue<>(Comparator.comparingInt(Road::getValue));
    static int[] root;
    static int count;
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0];
        root = new int[n];
        count = n;
        for(int i = 0; i < n; i++)
            root[i] = i;
        int m = arr[1];
        for (int i = 0; i < m; i++) {
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            pq.add(new Road(arr[0]-1, arr[1]-1, arr[2]));
        }
        if(pq.size() == 1) {
            System.out.println(0);
            return;
        }
        while (!pq.isEmpty()) {
            Union(pq.poll());
            if(count==2)
                break;
        }
        System.out.println(sum);
    }

    public static int find(int a) {
        if (a == root[a])
            return a;
        return root[a] = find(root[a]);
    }

    public static void Union(Road road) {
        int a = road.a;
        int b = road.b;
        int value = road.value;

        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot != bRoot) {
            if (aRoot < bRoot)
                root[bRoot] = aRoot;
            else
                root[aRoot] = bRoot;
            count--;
            sum += value;
        }
    }

    public static class Road {
        int a;
        int b;
        int value;

        public Road(int a, int b, int value) {
            this.a = a;
            this.b = b;
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
