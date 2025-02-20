import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        Deque<Integer> deque = new ArrayDeque<>();
        
        for(int i : arr)
            deque.add(i);
        
        for(int i = 0; i<query.length; i++){
            if(i%2==0){ //짝수
                int max = deque.size();
                for(int x = 0; x < max-(query[i]+1); x++)
                    deque.pollLast();
            }
            else{       //홀수
                for(int x = 0; x < query[i]; x++)
                    deque.pollFirst();
            }
        }
        return deque.stream().mapToInt(i -> i.intValue()).toArray();
    }
}