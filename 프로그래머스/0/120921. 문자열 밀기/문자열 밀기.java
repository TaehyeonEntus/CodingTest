class Solution {
    public int solution(String A, String B) {
        if(A.equals(B))
            return 0;
        
        String answer = new String(A);
        for(int i = 1; i<A.length(); i++){
            answer = pushOne(answer);
            if(answer.equals(B))
                return i;
        }
        
        return -1;
    }
    
    public String pushOne(String str){
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(str.length()-1));
        
        for(int i = 0; i<str.length()-1; i++)
            sb.append(str.charAt(i));
        
        return sb.toString();
    }
}