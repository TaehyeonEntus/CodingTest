import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        ArrayList<String> list = new ArrayList<>();
        for(String str : strArr)
            if(!str.contains("ad"))
                list.add(str);
        String[] answer = list.toArray(String[]::new);
        return answer;
    }
}