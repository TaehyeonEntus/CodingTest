
class Solution {
    static int result = 0;
    
    static boolean isDangerousZone(int x, int y, int[][] zone){ //이 지점이 위험한 지점인지 파악
        for(int i = x-1; i<=x+1; i++){
            for(int j = y-1; j<=y+1; j++){
                try{
                    if(zone[i][j] == 1)     //주변에 폭탄이 있을 시
                        return true;
                    } 
                catch (ArrayIndexOutOfBoundsException e) {
                        continue; // 인덱스 오류 발생 시 현재 반복을 건너뜀
                    }
            }
        }
        return false;
    }
    
    public int solution(int[][] board) {
        int n = board.length;
        for(int i = 0; i<n; i++)
            for(int j = 0; j<n; j++){
                if(isDangerousZone(i,j, board))
                    continue;
                else            //위험한 지점이 아니라면 result ++ 
                    result++;
            }
        
        int answer = result;
        return answer;
    }
}