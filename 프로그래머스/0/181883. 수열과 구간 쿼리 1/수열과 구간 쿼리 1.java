class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int startNumber;
        int endNumber;
        for(int[] query : queries){
            startNumber = query[0];
            endNumber = query[1];
            
            for(int i = startNumber; i<=endNumber; i++)
                arr[i]++;
        }
        return arr;
    }
}