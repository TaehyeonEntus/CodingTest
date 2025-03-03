import java.util.*;

class Solution {
    public String[] solution(String my_str, int n) {
        List<String> answer = new ArrayList<>();
        int maxSize = my_str.length()/n;
        if((my_str.length()%n)!=0)
            maxSize++;
        
        for(int i = 0; i< maxSize; i++){
            if(((i+1)*n)>my_str.length())
                answer.add(my_str.substring(i*n,my_str.length()));
            else
                answer.add(my_str.substring(i*n,(i+1)*n));
        }
        return answer
            .stream()
            .toArray(String[]::new);
    }
}