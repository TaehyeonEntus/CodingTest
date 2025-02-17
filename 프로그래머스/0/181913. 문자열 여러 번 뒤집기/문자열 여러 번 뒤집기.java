class Solution {
    public String solution(String my_string, int[][] queries) {
        String answer = my_string;
        for(int[] query : queries){
            answer = swap(answer,query[0],query[1]);
        }
        return answer;
    }
    
    public String swap(String string, int a, int b){
        StringBuilder sb = new StringBuilder();
        String first = string.substring(0,a);
        String reverse = string.substring(a,b+1);
        String last = string.substring(b+1,string.length());
        
        sb.append(reverse);
        sb.reverse();
        sb.insert(0,first);
        sb.append(last);
        
        return sb.toString();
    }
}