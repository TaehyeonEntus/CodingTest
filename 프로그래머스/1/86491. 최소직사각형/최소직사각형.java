import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int max_garo = 0;
        int max_sero = 0;
        for(int i = 0; i<sizes.length; i++)     //정렬
            Arrays.sort(sizes[i]);
        
        for(int i = 0; i<sizes.length; i++){    
            if(sizes[i][0]>max_garo)        //가로길이
                max_garo = sizes[i][0];
            
            if(sizes[i][1]>max_sero)        //세로길이
                max_sero = sizes[i][1];
        }
        
        int answer = max_sero * max_garo;
        return answer;
    }
}