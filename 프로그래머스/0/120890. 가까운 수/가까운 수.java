import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        int[] arr = array;
        Arrays.sort(arr);
        
        if(arr[0]>=n)
            return arr[0];
        
        if(arr[arr.length-1]<=n)
            return arr[arr.length-1];
        
        if(arr.length==1)
            return arr[0];
        
        for(int i = 0; i<arr.length-1; i++){
            int left = arr[i];
            int right = arr[i+1];
            if((n>=left) && (n<=right)){
                int leftDif = Math.abs(n - left);
                int rightDif = Math.abs(n - right);
                return leftDif < rightDif ? arr[i] : rightDif < leftDif ? arr[i+1] : arr[i];
            }
        }
        
        return 0;
    }
}