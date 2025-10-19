import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[][] map;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            map = new int[9][9];
            for (int i = 0; i < 9; i++)
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int answer = 1;

            for (int i = 0; i < 9; i++) {
                boolean[] visited_r = new boolean[9];
                boolean[] visited_c = new boolean[9];
                for (int j = 0; j < 9; j++) {
                    if (visited_r[map[i][j] - 1])
                        answer = 0;
                    else
                        visited_r[map[i][j] - 1] = true;


                    if (visited_c[map[j][i] - 1])
                        answer = 0;
                    else
                        visited_c[map[j][i] - 1] = true;
                }
            }

            Set<Integer>[][] sections = new Set[3][3];
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    sections[i][j] = new HashSet<>();
                }
            }

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++){
                    sections[i/3][j/3].add(map[i][j]);
                }
            }

            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    if(sections[i][j].size() != 9)
                        answer = 0;
                }
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}