class Solution {
    public int[] solution(int[] arr) {
        int first2Index = -1;
        int last2Index = -1;
        
        for(int i = 0; i<arr.length; i++){
            if(arr[i]==2){
                first2Index=i;
                break;
            }
        }
        
        for(int i = arr.length-1; i>=0; i--){
            if(arr[i]==2){
                last2Index=i;
                break;
            }
        }
        
        int[] answer;
        
        if((first2Index == -1)&& (last2Index==-1)){
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        
        answer = new int[last2Index-first2Index+1];
        for(int i = 0; i<last2Index-first2Index+1; i++){
            answer[i] = arr[first2Index+i];
        }
        return answer;
    }
}