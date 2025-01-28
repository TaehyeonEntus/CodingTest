import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        ArrayList<String> arrayList = new ArrayList<>();
        int myStrLen = my_string.length();
        for(int i = 0; i<myStrLen;i++)
            arrayList.add(my_string.substring(i,myStrLen));
        
        arrayList.sort(Comparator.naturalOrder());
            
        return arrayList.toArray(String[]::new);
    }
}