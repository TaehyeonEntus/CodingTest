import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        ArrayList<Integer> answerArray = new ArrayList<>();
        for(int i : arr)
            answerArray.add(i);
        ArrayList<Integer> deleteArray = new ArrayList<>();
        for(int i : delete_list)
            deleteArray.add(i);
        
        answerArray.removeAll(deleteArray);
        return answerArray.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}