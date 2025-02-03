class Solution {
    public int[] solution(int[] arr, int k) {
        int arrLength = arr.length;
        if(k%2==0)
            for(int i = 0; i<arrLength; i++)
                arr[i]+=k;
        else
            for(int i = 0; i<arrLength; i++)
                arr[i]*=k;
        return arr;
    }
}