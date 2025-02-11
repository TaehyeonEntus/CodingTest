class Solution {
    public String solution(String my_string, int s, int e) {
        StringBuilder sb = new StringBuilder();
        String targetString = my_string.substring(s,e+1);
        sb.append(targetString);
        String reversedString = sb.reverse().toString();
        
        String answer = my_string.replace(targetString, reversedString);
        
        return answer;
    }
}