import java.util.*;

class Solution {
    public void InitMap(Map<String, Integer> map,String[] want, int[] number){
        for(int i = 0; i<want.length; i++)
            map.put(want[i],number[i]);
    }
    
    public boolean checkMap(Map<String, Integer> map) {
        for (int value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for(int i = 0; i<discount.length-9; i++){
            Map<String, Integer> map = new HashMap<String, Integer>();
            InitMap(map,want,number);
            for(int j = i; j<i+10; j++){
                String key = discount[j];
                if (map.containsKey(key)) {
                    int value = map.get(key) - 1;
                    map.put(key, value);
                }
            }
            if(checkMap(map))
                answer++;
        }
        return answer;
    }
}