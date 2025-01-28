import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        int listLength = num_list.length;
        for(int i = n; i<listLength;i++)
            list.add(Integer.valueOf(num_list[i]));
        for(int i = 0; i<n;i++)
            list.add(Integer.valueOf(num_list[i]));
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}