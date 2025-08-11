import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    //0,0이 B일때
    static int[][] dp_black;
    //0,0이 W일때
    static int[][] dp_white;

    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] intArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = intArr[0];
        int m = intArr[1];
        int k = intArr[2];

        board = new int[n][m];

        dp_black = new int[n+1][m+1];
        dp_white = new int[n+1][m+1];

        for (int i = 0; i < n; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < m; j++)
                board[i][j] = charArray[j] == 'B' ? 0 : 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int white = 0, black = 0;

                //i = 1, j = 1일 때 board[0][0]
                if ((i - 1 + j - 1) % 2 == 0) {
                    if (board[i - 1][j - 1] == 0)
                        white = 1;
                    else
                        black = 1;
                } else { // 홀수 칸 = 반대 색
                    if (board[i - 1][j - 1] == 1)
                        white = 1;
                    else
                        black = 1;
                }

                dp_white[i][j] = dp_white[i - 1][j] + dp_white[i][j - 1] - dp_white[i - 1][j - 1] + white;
                dp_black[i][j] = dp_black[i - 1][j] + dp_black[i][j - 1] - dp_black[i - 1][j - 1] + black;
            }
        }

        int min = 1_000_000_000;

        for (int i = 0; i <= n - k; i++) {
            for (int j = 0; j <= m - k; j++) {
                int x1 = i;
                int y1 = j;
                int x2 = i + k - 1;
                int y2 = j + k - 1;

                int whiteSum = dp_white[x2 + 1][y2 + 1] - dp_white[x1][y2 + 1] - dp_white[x2 + 1][y1] + dp_white[x1][y1];
                int blackSum = dp_black[x2 + 1][y2 + 1] - dp_black[x1][y2 + 1] - dp_black[x2 + 1][y1] + dp_black[x1][y1];

                int count = Math.min(whiteSum, blackSum);
                min = Math.min(min, count);
            }
        }

        System.out.println(min);
    }
}
