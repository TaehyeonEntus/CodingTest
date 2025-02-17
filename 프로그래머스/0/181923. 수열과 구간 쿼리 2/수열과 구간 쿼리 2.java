import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        
        for(int i = 0; i<queries.length; i++){
            int[] targetArray = Arrays.copyOfRange(arr, queries[i][0], queries[i][1]+1);
            Arrays.sort(targetArray);
            
            int max = -1;
            
            for(int j = 0; j<targetArray.length; j++){
                if(targetArray[j]>queries[i][2]){
                    max=targetArray[j];
                    break;
                }
            }
            
            if(max!=-1)
                answer[i]=max;
            else
                answer[i]=-1;
        }
        
        return answer;
    }
}