import java.util.*;

class Solution {
    public int solution(int[] sides) {
        int[] arr = sides;
        Arrays.sort(arr);
        
        return arr[0]+arr[1] > arr[2] ? 1:2;
    }
}