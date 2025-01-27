import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = {};
        
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i : num_list)
            arrayList.add(Integer.valueOf(i));
        arrayList.sort(Comparator.naturalOrder());
        
        for(int i = 0; i<5;i++)
            arrayList.remove(0);
        
        answer = arrayList.stream().mapToInt(i->i).toArray();
        return answer;
    }
}