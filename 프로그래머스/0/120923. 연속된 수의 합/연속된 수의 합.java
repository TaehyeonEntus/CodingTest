import java.util.*;

class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        
        int center = total/num;
        int startInt = center - (num/2);
        
        if((total%num)!=0)
            startInt++;
        
        for(int i = 0; i < num; i++){
            answer[i] = startInt++;
        }
        
        return answer;
    }
}