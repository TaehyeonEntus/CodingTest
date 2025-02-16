import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int count = -1;
        int[] temp = {}; 
        while(!Arrays.equals(arr, temp)){
            temp = Arrays.copyOf(arr, arr.length);
            for(int i=0; i<arr.length; i++){
                if((arr[i]%2==0)&&(arr[i]>=50))
                    arr[i]/=2;
                else if((arr[i]%2==1)&&(arr[i]<50)){
                    arr[i]*=2;
                    arr[i]++;
                }
            }
            count++;
        }
        return count;
    }
}