import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int listLength = num_list.length;
        int[] answerList = Arrays.copyOf(num_list, listLength+1); 
        boolean isLastBig = num_list[listLength-1]>num_list[listLength-2];
        
        answerList[listLength] = isLastBig ? 
            num_list[listLength-1]-num_list[listLength-2] : num_list[listLength-1] * 2;
        return answerList;
    }
}