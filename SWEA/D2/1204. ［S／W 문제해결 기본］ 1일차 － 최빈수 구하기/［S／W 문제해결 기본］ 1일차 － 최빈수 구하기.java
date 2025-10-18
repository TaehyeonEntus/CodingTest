import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collector;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            map.clear();
            int n = Integer.parseInt(br.readLine());

            Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .forEach(i -> {
                        map.put(i, map.getOrDefault(i, 0) + 1);
                    });
            List<Pair> list = new ArrayList<>();
            map.entrySet().stream().map(i -> new Pair(i.getKey(), i.getValue())).forEach(list::add);
            list.sort(Comparator.comparingInt(Pair::getValue).reversed().thenComparing(Comparator.comparingInt(Pair::getKey).reversed()));

            System.out.println("#"+n+" "+list.get(0).key);
        }
    }

    public static class Pair {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }
}