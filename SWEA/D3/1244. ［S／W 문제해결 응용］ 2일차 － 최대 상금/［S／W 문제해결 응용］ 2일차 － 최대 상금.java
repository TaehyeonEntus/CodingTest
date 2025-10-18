import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static Set<String>[] sets;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String[] line = br.readLine().split(" ");
            String number = line[0];
            int depth = Integer.parseInt(line[1]);

            sets = new Set[depth + 1];
            for (int i = 0; i <= depth; i++)
                sets[i] = new HashSet<>();


            sets[0].add(number);
            for (int i = 1; i <= depth; i++) {
                for (String num : sets[i - 1]) {
                    for (int j = 0; j < number.length(); j++) {
                        for (int k = j + 1; k < number.length(); k++) {
                            sets[i].add(swap(num, j, k));
                        }
                    }
                }
            }

            int max = 0;
            for (String num : sets[depth])
                max = Math.max(max, Integer.parseInt(num));

            System.out.println("#" + t + " " + max);
        }
    }

    public static String swap(String number, int i, int j) {
        char a = number.charAt(i);
        char b = number.charAt(j);

        sb.setLength(0);
        sb.append(number);
        sb.setCharAt(j, a);
        sb.setCharAt(i, b);
        return sb.toString();
    }
}