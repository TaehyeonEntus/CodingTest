import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static long m;
    static int[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Long.parseLong(s[1]);

        matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] intArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = intArr;
        }

        int[][] resultMatrix = pow(matrix, m);

        // 출력
        for (int[] row : resultMatrix) {
            for (int num : row) {
                System.out.print(num % 1000 + " ");
            }
            System.out.println();
        }

    }

    //행렬 곱하기
    static int[][] multiply(int[][] a, int[][] b) {
        int[][] responseArray = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    responseArray[i][j] += (a[i][k] * b[k][j]) % 1000;
                }
                responseArray[i][j] %= 1000;
            }
        }
        return responseArray;
    }

    // 분할 정복 거듭제곱
    static int[][] pow(int[][] base, long exp) {
        if (exp == 1) {
            int[][] modBase = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    modBase[i][j] = base[i][j] % 1000;
                }
            }
            return modBase;
        }

        int[][] half = pow(base, exp / 2);
        int[][] halfSquared = multiply(half, half);
        if (exp % 2 == 0) {
            return halfSquared;
        } else {
            return multiply(halfSquared, base);
        }
    }
}
