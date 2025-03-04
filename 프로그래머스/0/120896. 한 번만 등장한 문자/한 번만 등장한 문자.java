import java.util.*;

class Solution {
    public String solution(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        String answer = String.valueOf(charArray);
        for(int i = 1; i<answer.length(); i++){
            if(answer.charAt(i) == answer.charAt(i-1))
                answer = answer.replace(answer.charAt(i),' ');
        }

        return answer.replace(" ", "");
    }
}