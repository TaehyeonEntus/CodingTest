class Solution {
    public int[] solution(int[] arr, int n) {
        int[] answer = {};
        int i = 0;
        if(arr.length%2==0)
            i=1;
        for(int k = i; k<arr.length;k += 2){
                arr[k] += n;
        }
        return arr;
    }
}