class Solution {
    public String solution(int[] numLog) {
        StringBuilder sb = new StringBuilder();
        int length = numLog.length;
        for(int i = 0; i< length-1;i++){
            int calc = numLog[i+1]-numLog[i];
            if(calc == 1)
                sb.append('w');
            else if(calc == -1)
                sb.append('s');
            else if(calc == 10)
                sb.append('d');
            else if(calc == -10)
                sb.append('a');
        }
        return sb.toString();
    }
}