import java.util.*;

class Solution {
    public int[] solution(int start_num, int end_num) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = start_num; i>=end_num;i--)
            arrayList.add(i);
        return arrayList.stream().mapToInt(Integer::intValue).toArray();
    }
}