class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for(int[] query : queries){
            swap(arr,query);
        }
        return arr;
    }
    
    public void swap(int[] intArr, int[] query){
        int a = intArr[query[0]];
        int b = intArr[query[1]];
        
        intArr[query[0]] = b;
        intArr[query[1]] = a;
    }
}