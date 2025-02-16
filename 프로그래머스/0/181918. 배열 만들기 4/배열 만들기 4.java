import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while(i<arr.length){
            if(list.isEmpty()){
                list.add(arr[i++]);
                continue;
            }
            
            if(list.get(list.size() - 1) >= arr[i]){
                list.remove(list.size() - 1);
                continue;
            }
            
            if(list.get(list.size() - 1) < arr[i]){
                list.add(arr[i++]);
                continue;
            }


        }
        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}