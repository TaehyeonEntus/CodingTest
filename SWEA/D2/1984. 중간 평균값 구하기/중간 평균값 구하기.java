import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static List<Double> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++) {
            list.clear();

            Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).forEach(list::add);
            list.sort(Comparator.naturalOrder());

            list.remove(list.size()-1);
            list.remove(0);

            sb.append("#").append(t).append(" ").append(Math.round(list.stream().mapToDouble(Double::doubleValue).sum()/list.size())).append("\n");
        }
        System.out.println(sb);
    }
}