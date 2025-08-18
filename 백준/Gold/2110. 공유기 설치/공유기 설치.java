import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = arr[0];
        int c = arr[1];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(Integer.parseInt(br.readLine()));
        Collections.sort(list);

        int start = 1;
        int end = list.get(n - 1) - list.get(0);
        int answer = 0;
        while (start <= end) {
            int distance = (start + end) / 2;
            int houses = 1;
            int lastHouse = list.get(0);
            for (int i = 1; i < n; i++) {
                if (list.get(i) - lastHouse >= distance) {
                    houses++;
                    lastHouse = list.get(i);
                }
            }
            if (houses >= c) {
                answer = Math.max(answer, distance);
                start = distance + 1;
            } else {
                end = distance - 1;
            }
        }
        System.out.println(answer);
    }
}
