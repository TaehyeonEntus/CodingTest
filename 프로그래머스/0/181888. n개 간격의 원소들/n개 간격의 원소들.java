import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        List<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i<num_list.length; i+=n)
            arrayList.add(Integer.valueOf(num_list[i]));
        return arrayList.stream().mapToInt(Integer::intValue).toArray();
    }
}