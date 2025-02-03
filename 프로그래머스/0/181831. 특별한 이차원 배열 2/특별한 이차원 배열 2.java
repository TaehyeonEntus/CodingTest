class Solution {
    public int solution(int[][] arr) {
        int arrLength = arr.length;
        for(int i = 0; i<arrLength; i++)
            for(int k = 0; k<arrLength; k++)
                if(arr[i][k] != arr[k][i])
                    return 0;
        return 1;
    }
}