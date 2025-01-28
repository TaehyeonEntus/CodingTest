import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int answer = -1;
        for(int i : num_list){
            arrayList.add(Integer.valueOf(i));
            if(i<0){
                answer = arrayList.indexOf(i);
                break;
            }
        }
        
        return answer;
    }
}