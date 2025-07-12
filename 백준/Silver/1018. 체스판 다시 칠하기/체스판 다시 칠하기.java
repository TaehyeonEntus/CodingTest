import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int x = Integer.parseInt(str[0]);
        int y = Integer.parseInt(str[1]);

        char[][] board = new char[x][y];
        for (int i = 0; i < x; i++) {
            char[] charArr = br.readLine().toCharArray();
            for (int j = 0; j < y; j++) {
                board[i][j] = charArr[j];
            }
        }
        int min = 9999;
        int count1;
        int count2;
        for (int i = 0; i <= x - 8; i++) {
            for (int j = 0; j <= y - 8; j++) {
                count1 = 0;
                count2 = 0;
                // 8*8 잘라낸 후
                for (int row = i; row < i + 8; row++) {
                    for (int col = j; col < j + 8; col++) {
                        int curX = row - i;
                        int curY = col - j;
                        if ((curX + curY) % 2 == 0) {
                            if (board[row][col] != 'B')
                                count1++;
                            if (board[row][col] != 'W')
                                count2++;
                        }
                        else {
                            if (board[row][col] != 'W')
                                count1++;
                            if (board[row][col] != 'B')
                                count2++;
                        }
                    }
                }
                min = Math.min(min, count1);
                min = Math.min(min, count2);
            }
        }
        System.out.println(min);
    }
}