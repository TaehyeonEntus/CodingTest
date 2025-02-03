import java.util.*;


class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        ArrayList<Integer> list = new ArrayList<>();
        int startIndex;
        int endIndex;
        
        for(int[] array : intervals){
            startIndex = array[0];
            endIndex = array[1];
            
            for(int i = startIndex; i<=endIndex;i++)
                list.add(arr[i]);
        }
            
        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}