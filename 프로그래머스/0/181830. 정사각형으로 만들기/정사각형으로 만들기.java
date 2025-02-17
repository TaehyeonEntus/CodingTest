import java.util.*;

class Solution {
    public int[][] solution(int[][] arr) {
        int width = arr.length;
        int height = 0;
        for(int[] array : arr){
            height = array.length>height? array.length:height;
        }
        
        int x = Math.max(width,height);
        
        int[][] answer = new int[x][x];
        
        int[] emptyArray = {0};
        for(int i = 0; i<x ; i++){
            try{
                answer[i] = Arrays.copyOfRange(arr[i],0, x);
            }
            catch(Exception e){
                answer[i] = Arrays.copyOfRange(emptyArray,0, x);
            }
        }
        
        return answer;
    }
}