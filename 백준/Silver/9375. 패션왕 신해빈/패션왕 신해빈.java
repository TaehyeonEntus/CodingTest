import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            map.clear();
            int N = Integer.parseInt(br.readLine());
            for (int j = 0; j < N; j++) {
                String[] line = br.readLine().split(" ");
                if (map.containsKey(line[1]))
                    map.put(line[1], map.get(line[1]) + 1);
                else
                    map.put(line[1], 1);
            }
            int answer = 1;
            List<Integer> list = new ArrayList<>(map.values());
            for(int num : list)
                answer *= (num + 1);

            System.out.println(answer-1);
        }
    }

}

