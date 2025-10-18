import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collector;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] range = {-2, -1, 1, 2};

    public static void main(String[] args) throws IOException {
        for (int t = 1; t <= 10; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] buildings = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int total = 0;
            for(int i = 0; i<n; i++){
                int max = 0;
                for(int dist : range)
                    if(dist + i >= 0 && dist + i < n)
                        max = Math.max(max, buildings[dist + i]);
                total += (Math.max(buildings[i] - max, 0));
            }
            System.out.println("#"+t+" "+total);
        }
    }
}