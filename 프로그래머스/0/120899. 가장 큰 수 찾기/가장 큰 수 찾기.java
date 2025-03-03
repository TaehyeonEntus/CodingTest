import java.util.*;

class Solution {
    public int[] solution(int[] array) {
        int maxInt = 0;
        int maxIndex = 0;
        for(int i = 0; i<array.length; i++){
            if(maxInt < Math.max(array[i], maxInt)){
                maxIndex = i;
                maxInt = array[i];
            }
        }
        int[] answer = {maxInt, maxIndex};
        return answer;
    }
}