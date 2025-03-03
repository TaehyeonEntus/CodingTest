import java.util.*;

class Solution {
    public int[] solution(int n, int[] numlist) {
        List<Integer> list = new ArrayList<>();
        for(int i : numlist){
            if(i%n==0)
                list.add(Integer.valueOf(i));
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}