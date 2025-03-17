import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        
        for(char c : my_string.toCharArray()){
            list.add(String.valueOf(c));
        }
        
        List<String> distinct = list.stream().distinct().collect(Collectors.toList());
        
        for(String str : distinct){
            sb.append(str);
        }
        
        return sb.toString();
    }
}