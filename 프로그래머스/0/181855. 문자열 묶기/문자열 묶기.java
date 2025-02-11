import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        Map<Integer, Integer> map = new HashMap<>();    //Length, Count
        for(String str : strArr){
            Integer key = Integer.valueOf(str.length());
            if(map.get(key)!=null)
                map.put(key, map.get(key)+1);
            else
                map.put(key, 1);
        }
        return Collections.max(map.values()).intValue();
    }
}