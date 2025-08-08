import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<Integer, Integer> dp;
    static int[] number;
    static List<Wire> wires;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new HashMap<>();
        wires = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            wires.add(new Wire(arr[0], arr[1]));
        }

        wires.sort(Wire::compareTo);

        int[] intArr = new int[n];
        for(int i = 0; i < n; i++) {
            intArr[i] = wires.get(i).b;
        }

        dp.put(intArr[0], 1);
        for (int i = 1; i < n; i++) {
            int maxLen = 0;
            for (Integer key : dp.keySet())
                if (key < intArr[i])
                    maxLen = Math.max(maxLen, dp.get(key));
            dp.put(intArr[i], maxLen + 1);
        }
        int max = 0;
        for(Integer value : dp.values()) {
            max = Math.max(max, value);
        }
        System.out.println(n-max);
    }

    public static class Wire implements Comparable<Wire> {
        int a;
        int b;

        Wire(int a, int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Wire o) {
            return Integer.compare(this.a, o.a);
        }
    }
}