class Solution {
    public int solution(int[][] board, int k) {
        int xLength = board.length;
        int yLength = board[0].length;
        
        int answer = 0;
        
        for(int i = 0; i<xLength; i++)
            for(int j = 0; j<yLength; j++)
                if((i+j)<=k)
                    answer+=board[i][j];
        return answer;
    }
}