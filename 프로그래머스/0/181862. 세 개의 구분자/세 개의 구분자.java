import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        String[] answer = {};
        String[] splittedStrArray = 
            myStr
            .replace("a"," ")
            .replace("b"," ")
            .replace("c"," ")
            .split(" ");
        List<String> list = new ArrayList<>();
        
        for(String str : splittedStrArray){
            if(!str.isEmpty())
                list.add(str);
        }
        if(list.isEmpty()){
            list.add("EMPTY");
        }
        
        return list.toArray(String[]::new);
    }
}