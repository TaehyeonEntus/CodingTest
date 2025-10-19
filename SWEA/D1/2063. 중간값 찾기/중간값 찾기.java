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
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(list::add);
        list.sort(Comparator.naturalOrder());

        System.out.println(list.get(n/2));
    }
}