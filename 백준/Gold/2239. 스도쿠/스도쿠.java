import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[][] sudoku = new int[9][9];
    static int[][] answer = new int[9][9];
    static List<Pair> list = new ArrayList<>();
    static boolean find = false;


    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 9; i++)
            sudoku[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (sudoku[i][j] == 0)
                    list.add(new Pair(i, j));

        dfs(0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                sb.append(answer[i][j]);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if (find)
            return;

        if (depth == list.size()) {
            for(int i =0; i<9; i++) {
                answer[i] = sudoku[i].clone();
            }
            find = true;
            return;
        }

        Pair p = list.get(depth);
        int x = p.x;
        int y = p.y;
        for (int i = 1; i <= 9; i++) {
            //가로, 세로 검사
            boolean checkBox = false;
            for (int j = 0; j < 9; j++) {
                if (sudoku[x][j] == i) {
                    checkBox = true;
                    break;
                }
                if (sudoku[j][y] == i) {
                    checkBox = true;
                    break;
                }
            }

            if (checkBox)
                continue;

            //섹션 검사
            int row = (x / 3) * 3;
            int col = (y / 3) * 3;
            for (int r = row; r < row + 3; r++) {
                for (int c = col; c < col + 3; c++) {
                    if (sudoku[r][c] == i) {
                        checkBox = true;
                        break;
                    }
                }
            }

            if (checkBox)
                continue;

            sudoku[x][y] = i;
            dfs(depth + 1);
            sudoku[x][y] = 0;
        }

    }

    public static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
