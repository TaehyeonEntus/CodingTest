class Solution {
    public String solution(String myString) {
        StringBuilder sb = new StringBuilder();
        char[] charArray = myString.toCharArray();
        
        for(char c : charArray){
            if(c<'l')
                sb.append('l');
            else
                sb.append(c);
        }
        
        
        return sb.toString();
    }
}