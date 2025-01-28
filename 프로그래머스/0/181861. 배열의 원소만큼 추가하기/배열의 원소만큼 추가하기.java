import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        List<Integer> arrayList = new ArrayList<>();
        for(int i : arr)
            for(int k = 0; k<i; k++)
                arrayList.add(Integer.valueOf(i));
        
        
        return arrayList.stream().mapToInt(Integer::intValue).toArray();
    }
}