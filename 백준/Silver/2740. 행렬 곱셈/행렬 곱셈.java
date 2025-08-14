import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int k;
    static int[][] matrixA;
    static int[][] matrixB;
    static int[][] answerMatrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] intArrA = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = intArrA[0];
        m = intArrA[1];

        matrixA = new int[n][m];
        matrixB = new int[m][k];
        for (int i = 0; i < n; i++) {
            matrixA[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[] intArrB = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        m = intArrB[0];
        k = intArrB[1];

        for (int i =0; i < m; i++) {
            matrixB[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        answerMatrix = new int[n][k];
        for(int a = 0; a < n; a++) {
            for(int b = 0; b < k; b++) {
                for(int c = 0; c < m; c++) {
                    answerMatrix[a][b] += matrixA[a][c] * matrixB[c][b];
                }
            }
        }

        for(int[] intArr : answerMatrix) {
            for(int num : intArr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
