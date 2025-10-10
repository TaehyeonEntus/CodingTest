import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static List<Pair> list = new ArrayList<>();
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            double[] arr = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            list.add(new Pair(arr[0], arr[1]));
        }
        list.add(list.get(0));

        System.out.printf("%.1f",solve());
    }

    public static double solve() {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            Pair p1 = list.get(i);
            Pair p2 = list.get(i + 1);
            sum += (p1.x * p2.y) - (p1.y * p2.x);
        }

        return Math.abs(sum/2);
    }

    public static class Pair {
        double x;
        double y;

        public Pair(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}