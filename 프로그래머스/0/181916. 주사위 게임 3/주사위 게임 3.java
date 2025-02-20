import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = {a,b,c,d};
        Arrays.sort(arr);
        int answer = 0;
        for(int i : arr){
            Integer intValue = Integer.valueOf(i);
            if(map.get(intValue)==null)
                map.put(intValue,1);
            else
                map.put(intValue,map.get(intValue)+1);
        }
        
        Set<Integer> keySet = map.keySet();
        int count = keySet.size();
        if(count == 1){ //같은숫자 4개
            answer += (1111*arr[0]);
        }
        else if(count == 2){ //2,2 or 1,3
            if(map.containsValue(Integer.valueOf(2))){  //2,2
                answer += (arr[0]+arr[3])*Math.abs(arr[0]-arr[3]);
            }
            else{
                if(arr[0]!=arr[1])                      //3,1
                    answer += (10*arr[1]+arr[0])*(10*arr[1]+arr[0]);
                else
                    answer += (10*arr[2]+arr[3])*(10*arr[2]+arr[3]);
            }
        }
        else if(count == 3){
            answer = 1;
            for(Integer key : keySet)
                if(map.get(key) == 1)
                    answer *= key.intValue();
        }
        else
            answer = arr[0];
        return answer;
    }
}