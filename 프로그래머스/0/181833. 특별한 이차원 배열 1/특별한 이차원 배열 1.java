class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        for(int i = 0; i<n; i++)
            for(int k = 0; k<n; k++)
                answer[i][k] = i==k ? 1:0;
                
        return answer;
    }
}