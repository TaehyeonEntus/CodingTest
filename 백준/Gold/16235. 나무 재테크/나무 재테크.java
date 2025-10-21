import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int n;
    static int m;
    static int k;

    static List<Integer>[][] trees;
    static int[][] plus;
    static int[][] map;

    static int[] dx = {-1, 1, 0, 0, 1, 1, -1, -1};
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        m = arr[1];
        k = arr[2];

        trees = new List[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                trees[i][j] = new ArrayList<>();

        map = new int[n][n];
        plus = new int[n][n];

        for (int i = 0; i < n; i++) {
            plus[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.fill(map[i],5);
        }


        for (int i = 0; i < m; i++) {
            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = arr[0] - 1;
            int y = arr[1] - 1;
            int age = arr[2];
            trees[x][y].add(age);
        }

        for (int year = 0; year < k; year++) {
            spring_summer();
            autumn();
            winter();
        }

        int total = 0;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                total += trees[i][j].size();

        System.out.println(total);
    }

    public static void spring_summer() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                trees[i][j].sort(Comparator.naturalOrder());
                int treeLen = trees[i][j].size();
                int deadTrees = 0;
                for (int num = 0; num < treeLen; num++) {
                    int peek = trees[i][j].get(0);
                    if (map[i][j] >= peek) {
                        map[i][j] -= peek;
                        trees[i][j].add(peek + 1);
                    } else {
                        deadTrees += peek/2;
                    }
                    trees[i][j].remove(0);
                }
                map[i][j] += deadTrees;
            }
    }

    public static void autumn() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int tree : trees[i][j])
                    if (tree % 5 == 0) {
                        for(int dir = 0; dir < 8; dir++) {
                            int x = i + dx[dir];
                            int y = j + dy[dir];

                            if (x < 0 || x >= n || y < 0 || y >= n)
                                continue;

                            trees[x][y].add(1);
                        }
                    }
    }

    public static void winter() {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                map[i][j] += plus[i][j];
    }
}