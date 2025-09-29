import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] root;

    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = arr[0];
        int m = arr[1];

        root = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            root[i] = i;
        }

        for (int i = 0; i < m; i++) {
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int command = arr[0];
            int a = arr[1];
            int b = arr[2];

            if (command == 0)
                Union(a,b);

            if (command == 1)
                isUnion(a, b);
        }
    }

    public static int findRoot(int number) {
        if (number == root[number]) {
            return number;
        }
        return root[number] = findRoot(root[number]);
    }

    public static void Union(int a, int b) {
        int x = findRoot(a);
        int y = findRoot(b);

        if (x == y) return;

        if(x<y) {
            root[y] = x;
        }else {
            root[x] = y;
        }
    }

    public static void isUnion(int a, int b) {
        if (findRoot(a) == findRoot(b))
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}