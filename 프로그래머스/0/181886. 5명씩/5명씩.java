import java.util.*;

class Solution {
    public String[] solution(String[] names) {
        List<String> arrayList = new ArrayList<>();
        
        for(int i = 0; i<names.length;i+=5)
            arrayList.add(names[i]);
        return arrayList.toArray(String[]::new);
    }
}