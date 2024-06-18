import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int max = triangle.length;
        int[][] maxTriangle = new int[max][];
        
        for (int i = 0; i < max; i++) {
            maxTriangle[i] = Arrays.copyOf(triangle[i], triangle[i].length);   
        }
        
        for(int i = max-2; i >= 0; i--)
            for(int j = 0; j<triangle[i].length; j++)
                maxTriangle[i][j] += Math.max(maxTriangle[i + 1][j], maxTriangle[i + 1][j + 1]);
        //n번째 칸에서 아래 두 값 중에 큰값을 선택하는 방식
        return maxTriangle[0][0];   //꼭대기에는 최대값 저장
    }
}