import java.util.Arrays;

class Solution {
    private int zero;
    private int one;

    private void quadTreeSum(int garoPoint, int seroPoint, int n, int[][] arr) {
        int sum = 0;
        for (int i = garoPoint; i < garoPoint + n; i++) {
            for (int j = seroPoint; j < seroPoint + n; j++) {
                sum += arr[i][j];
            }
        }

        if (sum == 0) {
            zero++;
        }
 
        else if (sum == n * n) {
            one++;

        } else {
            
            n /= 2;
            quadTreeSum(garoPoint, seroPoint, n, arr);
            quadTreeSum(garoPoint, seroPoint + n, n, arr);
            quadTreeSum(garoPoint + n, seroPoint, n, arr);
            quadTreeSum(garoPoint + n, seroPoint + n, n, arr);
        }
    }

    public int[] solution(int[][] arr) {
        zero = 0;
        one = 0;

        quadTreeSum(0, 0, arr.length, arr);
        return new int[] {zero, one};
    }
}
