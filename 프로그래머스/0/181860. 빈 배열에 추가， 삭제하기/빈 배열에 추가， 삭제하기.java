import java.util.*;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        Deque<Integer> stack = new ArrayDeque<>();
        int arrLength = arr.length;
        for(int i = 0; i<arrLength; i++){
            for(int j = 0; j<arr[i]; j++){
                if(flag[i]){
                    stack.push(arr[i]);
                    stack.push(arr[i]);
                }
                else
                    stack.pop();
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!stack.isEmpty())
            list.add(stack.pop());
        
        Collections.reverse(list);
        
        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}