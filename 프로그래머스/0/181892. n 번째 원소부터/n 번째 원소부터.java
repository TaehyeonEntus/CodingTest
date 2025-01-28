import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = n-1; i<num_list.length; i++)
            arrayList.add(num_list[i]);
        return arrayList.stream().mapToInt(Integer::intValue).toArray();
    }
}