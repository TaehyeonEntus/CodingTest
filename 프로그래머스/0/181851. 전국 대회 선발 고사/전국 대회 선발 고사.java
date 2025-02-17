import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        //key = 등수, value = 번호
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<rank.length; i++){
            if(attendance[i])
                map.put(rank[i],i);
        }
        
        List<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        
        int total = 0;
        total+=(10000*map.get(keySet.get(0)));
        total+=(100*map.get(keySet.get(1)));
        total+=(1*map.get(keySet.get(2)));
        
        return total;
    }
}