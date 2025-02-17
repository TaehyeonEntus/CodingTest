import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; (i<arr.length && list.size()<k);i++){
            if(!list.contains(Integer.valueOf(arr[i])))
                list.add(Integer.valueOf(arr[i]));
        }
        
        for(int i = list.size(); i<k; i++){
            list.add(Integer.valueOf(-1));
        }

        return list.stream().mapToInt(i->i).toArray();

    }
}